package com.linnyk.ocp.concurrency.course_1.creating_threads;

/**
 * Поток можно создать 2 способами,
 * 	- extends Thread
 * 	- implements Runnable
 *
 * 	Повторно start() вызывать нельзя на одном и том же потоке, будет IllegalThreadStateException
 */
public class CreatingThread {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());

		final MyThread myThread = new MyThread(); //новый поток
		myThread.start(); // старт нового потока

		final Thread thread = new Thread(new MyRunnable());
		thread.start();
	}
}

class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("This is new thread");
	}

}

class MyRunnable implements Runnable{

	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("This is new runnable");
	}

}
