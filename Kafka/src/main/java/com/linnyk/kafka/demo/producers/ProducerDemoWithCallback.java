package com.linnyk.kafka.demo.producers;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemoWithCallback {

	public static void main(String[] args) {
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
			ProducerRecord<String, String> producerRecord = new ProducerRecord<>("my_topic", "Hello world " + 5);

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

			});
		}

		// flush
		producer.flush();

		// flush and close producer
		producer.close();
	}
}
