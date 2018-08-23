package com.linnyk.ocp.concurrency.course_1.wait_and_notify;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ThreadB threadB = new ThreadB();
		threadB.start();
		synchronized (threadB){
			System.out.println("Waiting");
			threadB.wait();
		}
		System.out.println("The total is " + threadB.total);
	}

	static class ThreadB extends Thread {

		int total;

		@Override
		public void run() {
			synchronized (this){
				for (int i = 0; i < 5; i++) {
					total += i;
					try {
						Thread.sleep(500);
					}
					catch (InterruptedException e) {}
					System.out.println("Total is " + total);
				}
				System.out.println("Notify");
				notify();
			}
		}
	}
}
