package br.com.mreboucas.kafka_template.consumer;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import br.com.mreboucas.kafka_template.producer.Producer;

/**
 * @author Marcelo Reboucas - marceloreboucas10@gmail.com - 11 de fev de 2020 as 14:53:19 
 */

public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Producer.class);

   @KafkaListener(topics = Producer.TOPIC, groupId = "group_id")
   public void consume(String message) throws IOException {
       logger.info(String.format("#### -> Consumed message -> %s", message));
   }
}