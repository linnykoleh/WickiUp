package com.linnyk.ocp.concurrency.course_3.daemon;

public class DaemonExample {

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(() -> {
			while (true){
				try {
					System.out.println("Not daemon is working");
					Thread.sleep(100);
				}
				catch (InterruptedException e) {
				}
			}

		});
		thread.setDaemon(false);
		thread.start();

		System.out.println("Main is working");
		Thread.sleep(1000);
		System.out.println("Main finished");
	}
}
