package com.linnyk.ocp.concurrency.course_1.synchronization_static_method;


public class Main {

	public static void main(String[] args) throws InterruptedException {

		/**
			Синхронизация должна быть статическая либо на уровне метода, их нельзя миксовать
		 */


		Resources.i = 5;

		final MyThread myThread = new MyThread();
		final MyThread myThread1 = new MyThread();

		myThread.setName("one");

		myThread.start();
		myThread1.start();

		myThread.join();
		myThread1.join();

		System.out.println(Resources.i);
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		Resources.changeI();
	}
}

class Resources {

	static int i; // синхронизация на уровне класса. Один лок на класс

	public synchronized static void changeI() {
		int i = Resources.i;
		if (Thread.currentThread().getName().equals("one")) {
			Thread.yield();
		}
		i++;
		Resources.i = i;
	}

}