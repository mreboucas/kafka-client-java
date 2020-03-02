package br.com.mreboucas.kafka_template.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Marcelo Reboucas - marceloreboucas10@gmail.com - 11 de fev de 2020 as 14:53:26 
 */

@Slf4j
@Service
public class Producer {

    public static final String TOPIC = "equipament";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info(String.format("#### -> Producing message -> %s", message));
        //this.kafkaTemplate.send(TOPIC, new Gson().toJson(message)));
        this.kafkaTemplate.send(TOPIC, message);
    }
	
}
