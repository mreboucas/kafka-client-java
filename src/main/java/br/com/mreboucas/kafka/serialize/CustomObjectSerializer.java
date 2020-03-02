package br.com.mreboucas.kafka.serialize;

import java.util.Map;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Marcelo Reboucas - marceloreboucas10@gmail.com - 11 de fev de 2020 as 10:30:26
 */

public class CustomObjectSerializer implements Serializer<Object> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override
	public byte[] serialize(String topic, Object data) {

		byte[] retVal = null;

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			retVal = objectMapper.writeValueAsString(data).getBytes();

		} catch (Exception exception) {

			System.out.println("Error in serializing object" + data);

		}

		return retVal;

	}

	@Override
	public void close() {

	}
}
