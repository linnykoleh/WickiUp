package com.linnyk.ocp.concurrency.course_1.atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	static AtomicInteger i = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		for (int j = 0; j < 10000; j++) {
			new MyThread().start();
		}
		Thread.sleep(1000);
		System.out.println(i);
	}

	static class MyThread extends Thread{

		@Override
		public void run() {
			i.incrementAndGet();
		}
	}
}
