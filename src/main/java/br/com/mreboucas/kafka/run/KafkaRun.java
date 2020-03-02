package br.com.mreboucas.kafka.run;

import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import br.com.mreboucas.kafka.consumer.ConsumerCreator;
import br.com.mreboucas.kafka.interfaces.IKafkaConstants;
import br.com.mreboucas.kafka.producer.ProducerCreator;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Marcelo Reboucas - marceloreboucas10@gmail.com - 11 de fev de 2020 as 10:49:46
 */

@Slf4j
public class KafkaRun {

	//private static String BROKER = IKafkaConstants.KAFKA_BROKERS_ALL_IN;
	private static String BROKER = IKafkaConstants.KAFKA_BROKERS_SINGLE;
	//private static String BROKER = IKafkaConstants.KAFKA_BRUNOS_MACHINE;

	public static void main(String[] args) {

		// String broker = IKafkaConstants.KAFKA_BROKERS_SINGLE;

		runProducer();

		// runConsumer();


	}

	static void runConsumer() {

		Consumer<Long, String> consumer = ConsumerCreator.createConsumer(BROKER);

		int noMessageFound = 0;

		while (true) {

			ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);

			// 1000 is the time in milliseconds consumer will wait if no record is found at broker.

			if (consumerRecords.count() == 0) {

				noMessageFound++;

				if (noMessageFound > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)

					// If no message found count is reached to threshold exit loop.

					break;

				else

					continue;

			}

			// print each record.

			consumerRecords.forEach(record -> {

				log.info("Record Key " + record.key());

				log.info("Record value " + record.value());

				log.info("Record partition " + record.partition());

				log.info("Record offset " + record.offset());

			});

			// commits the offset of record to broker.

			consumer.commitAsync();

		}

		consumer.close();

	}

	static void runProducer() {

		Producer<Long, String> producer = ProducerCreator.createProducer(BROKER);
		// producer.beginTransaction();

		for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {

			ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(IKafkaConstants.TOPIC_NAME, "This is record " + index);

			try {

				RecordMetadata metadata = producer.send(record).get();

				log.info("Record sent with key " + index + " to partition " + metadata.partition() + " with offset " + metadata.offset());
			}

			catch (InterruptedException | ExecutionException e) {

				log.error("Error in sending record");

				log.error(e.getMessage());
				producer.abortTransaction();
			}
		}

		producer.close();
	}
}
