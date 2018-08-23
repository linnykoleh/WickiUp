package com.linnyk.ocp.concurrency.course_3.concurrent_linked_queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {

	public static void main(String[] args) {

		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
	}
}

class Producer implements Runnable {

	ConcurrentLinkedQueue<String> queue;

	Producer(ConcurrentLinkedQueue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("Producer Started");
		try {
			for (int i = 1; i < 10; i++) {
				queue.add("" + i); // добавляются в хвост очереди
				System.out.println("Add: " + i);
				Thread.currentThread().sleep(1000);
			}
		} catch (Exception ex) {}
	}
}

class Consumer implements Runnable {

	ConcurrentLinkedQueue<String> queue;

	Consumer(ConcurrentLinkedQueue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		String str;
		System.out.println("Consumer Started");
		try {
			for (int x = 0; x < 10; x++) {
				while ((str = queue.poll()) != null) { // берутся из головы очереди
					System.out.println("Poll: " + str);
					Thread.currentThread().sleep(3000);
				}
			}
		} catch (Exception ex) {}
	}
}
