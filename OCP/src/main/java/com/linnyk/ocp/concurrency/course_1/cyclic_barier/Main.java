package com.linnyk.ocp.concurrency.course_1.cyclic_barier;

import java.util.concurrent.CyclicBarrier;

public class Main {

	/**
	 CyclicBarrier ждет когда стартонули все потоки (число передается в конструкторе new CyclicBarrier(3, new Run())) и только потом выполняет код

	 	System.out.println("Run is begun");

	 Если не зараниллось определенное чилсо потоков, то программа зависает и ждет всех

	 */

	public static void main(String[] args) throws InterruptedException {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());

		new SportsMan(cyclicBarrier).start();
		new SportsMan(cyclicBarrier).start();

		Thread.sleep(10000);

		new SportsMan(cyclicBarrier).start();
	}

	static class Run extends Thread {

		@Override
		public void run() {
			System.out.println("Run is begun");
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {}
		}
	}

	static class SportsMan extends Thread{
		CyclicBarrier cyclicBarrier;

		public SportsMan(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting");
				sleep(3000);
				cyclicBarrier.await();
				System.out.println(Thread.currentThread().getName() + " finish running");
			}
			catch (Exception e) {}
		}
	}
}
