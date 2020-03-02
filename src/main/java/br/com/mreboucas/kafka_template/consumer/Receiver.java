package br.com.mreboucas.kafka_template.consumer;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import br.com.mreboucas.kafka_template.producer.Producer;

public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = Producer.TOPIC)
	public void receive(String payload) {
		LOGGER.info("received payload='{}'", payload);
		latch.countDown();
	}
}
