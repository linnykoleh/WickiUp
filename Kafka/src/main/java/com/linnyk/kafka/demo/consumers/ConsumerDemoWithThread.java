package com.linnyk.kafka.demo.consumers;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerDemoWithThread {

	public static void main(String[] args) throws InterruptedException {
		String bootstrapServer = "127.0.0.1:9092";
		String groupId = "my-sixth-application";
		String topic = "my_topic";

		CountDownLatch countDownLatch = new CountDownLatch(1);
		ConsumerRunnable consumer = new ConsumerRunnable(bootstrapServer, groupId, topic, countDownLatch);
		Thread thread = new Thread(consumer);
		thread.start();

		countDownLatch.await();
	}
}

class ConsumerRunnable implements Runnable {

	private CountDownLatch countDownLatch;
	private KafkaConsumer<String, String> consumer;

	public ConsumerRunnable(String bootstrapServer, String groupId, String topic, CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;

		// 1. Create consumer configuration
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // earliest/latest/none

		this.consumer = new KafkaConsumer<>(properties);

		// 3. Subscribe on topic(s)
		this.consumer.subscribe(Arrays.asList(topic));
	}

	@Override
	public void run() {
		// 4. Poll for new data
		try {
			while (true) {
				final ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
				for (ConsumerRecord<String, String> record : records) {
					System.out.println("key: " + record.key());
					System.out.println("value: " + record.value());
					System.out.println("partition: " + record.partition());
					System.out.println("offset: " + record.offset());
					System.out.println("--------------------------------");
				}
			}
		}
		catch (WakeupException e) {
			System.err.println("Shutdown");
		}
		finally {
			this.consumer.close();
			this.countDownLatch.countDown();
		}
	}

	public void shutdown() {
		// used to interrupt consumer.poll
		consumer.wakeup();
	}
}

