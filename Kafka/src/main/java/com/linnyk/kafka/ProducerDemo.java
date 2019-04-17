package com.linnyk.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemo {

	public static void main(String[] args) {
		// 1. Create producer properties
		// 1.1 https://kafka.apache.org/documentation/#producerconfigs

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// 2. Create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		// 3. Create producer record
		ProducerRecord<String, String> producerRecord = new ProducerRecord<>("my_topic", "Hello world");

		// 4. Send data asynchronous
		producer.send(producerRecord);

		// flush
		producer.flush();

		// flush and close producer
		producer.close();
	}
}
