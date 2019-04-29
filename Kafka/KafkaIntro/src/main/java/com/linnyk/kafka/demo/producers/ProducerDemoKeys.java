package com.linnyk.kafka.demo.producers;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemoKeys {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 1. Create producer properties
		// 1.1 https://kafka.apache.org/documentation/#producerconfigs

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// 2. Create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		for (int i = 0; i < 5; i++) {

			// 3. Create producer record
			String topic = "my_topic";
			String value = "Hello world " + i;
			String key = "id_" + i;

			System.out.println("Key: " + key); // The same key goes to the same partition
			// id_0 -> partition: 1
			// id_1 -> partition: 0
			// id_2 -> partition: 2
			// id_3 -> partition: 0
			// id_4 -> partition: 2

			ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);

			// 4. Send data asynchronous
			producer.send(producerRecord, (metadata, exception) -> {
				// executes every time record is successfully sent or an exception is thrown
				if (exception == null) {
					System.out.println("Success sent");
					System.out.println("topic: " + metadata.topic());
					System.out.println("partition: " + metadata.partition());
					System.out.println("offset: " + metadata.offset());
					System.out.println("timestamp: " + metadata.timestamp());
					System.out.println("---------------------------");
				} else {
					System.out.println("Didn't sent: " + exception);
				}

			}).get(); // get - synchronous - don't do in production
		}

		// flush
		producer.flush();

		// flush and close producer
		producer.close();
	}
}
