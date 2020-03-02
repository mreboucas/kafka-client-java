package br.com.mreboucas.kafka.serialize;

import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Marcelo Reboucas - marceloreboucas10@gmail.com - 11 de fev de 2020 as 10:42:24
 */
@Slf4j
public class CustomObjectDeserializer implements Deserializer<Object> {

	@Override

	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override

	public Object deserialize(String topic, byte[] data) {

		ObjectMapper mapper = new ObjectMapper();

		Object object = null;

		try {

			object = mapper.readValue(data, Object.class);

		} catch (Exception exception) {

			log.error("Error in deserializing bytes " + exception);

		}

		return object;

	}

	@Override

	public void close() {

	}

}
