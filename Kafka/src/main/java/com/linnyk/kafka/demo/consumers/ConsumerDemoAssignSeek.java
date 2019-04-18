package com.linnyk.kafka.demo.consumers;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerDemoAssignSeek {

	public static void main(String[] args) {

		// Create consumer configuration
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my_application");
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // earliest/latest/none

		// 2. Create consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

		// assign and seek are mostly used to replay data or fetch a specific message
		TopicPartition partitionToReadFrom = new TopicPartition("my_topic", 1);
		long offset = 10L;

		consumer.assign(Arrays.asList(partitionToReadFrom));

		int numberOfMessagesToRead = 5;
		boolean keepOnReading = true;
		int numberOfMessagesSoFar = 0;
		// seek
		consumer.seek(partitionToReadFrom, offset);

		// Poll for new data
		while (keepOnReading) {
			final ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			for (ConsumerRecord<String, String> record : records) {
				numberOfMessagesToRead++;
				System.out.println("key: " + record.key());
				System.out.println("value: " + record.value());
				System.out.println("partition: " + record.partition());
				System.out.println("offset: " + record.offset());
				System.out.println("--------------------------------");

				if (numberOfMessagesSoFar >= numberOfMessagesToRead) {
					keepOnReading = false;
					break;
				}

			}
		}
	}
}
