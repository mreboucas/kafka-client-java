package br.com.mreboucas.kafka.partitioner;

import java.util.Map;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

/**
 * @author Marcelo Reboucas - marceloreboucas10@gmail.com - 11 de fev de 2020 as 10:33:46
 */

public class CustomPartitioner implements Partitioner {

	private static final int PARTITION_COUNT = 50;

	@Override
	public void configure(Map<String, ?> configs) {

	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

		Integer keyInt = Integer.parseInt(key.toString());

		return keyInt % PARTITION_COUNT;

	}

	@Override
	public void close() {

	}
}

