package com.linnyk.ocp.concurrency.course_1.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Main {

	private static final int NUMBER_OF_FINISHED_THREAD = 4;

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_FINISHED_THREAD);

		new Work(countDownLatch);
		new Work(countDownLatch);
		new Work(countDownLatch);

		System.out.println("Waiting until " + NUMBER_OF_FINISHED_THREAD + " threads finish");
		countDownLatch.await();
		System.out.println("All jobs are done");
	}

	static class Work extends Thread{
		CountDownLatch countDownLatch;

		public Work(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
			start();
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is working");
			try {
				sleep(3000);
			}
			catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName() + " is done");
			countDownLatch.countDown();
		}
	}
}
