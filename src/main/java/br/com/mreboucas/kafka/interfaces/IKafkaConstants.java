package br.com.mreboucas.kafka.interfaces;


/**
 * @author Marcelo Reboucas - marceloreboucas10@gmail.com - 11 de fev de 2020 as 10:19:45
 */

public interface IKafkaConstants {

	public static String KAFKA_BROKERS_SINGLE = "localhost:9093";
	
	public static String KAFKA_BROKERS_ALL_IN = "localhost:9092";
	
	public static String KAFKA_BRUNOS_MACHINE = "172.25.10.87:9092";

	public static Integer MESSAGE_COUNT = 100;

	public static String CLIENT_ID = "client1";

	public static String TOPIC_NAME = "equipament";

	public static String GROUP_ID_CONFIG = "consumerGroup1";

	public static Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;

	public static String OFFSET_RESET_LATEST = "latest";

	public static String OFFSET_RESET_EARLIER = "earliest";

	public static Integer MAX_POLL_RECORDS = 1;

}
