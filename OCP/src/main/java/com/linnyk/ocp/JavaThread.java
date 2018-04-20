package com.linnyk.ocp;

public class JavaThread implements Runnable {

	int i;

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			System.out.println("Got InterruptedException");
			i = 30;
		}
		i = 20;
	}

	public static void main(String[] args) throws InterruptedException {
		final JavaThread target = new JavaThread();
		final Thread thread = new Thread(target);
		thread.start();

		thread.interrupt();
		Thread.sleep(10);

		System.out.println(target.i); // 30
	}
}
