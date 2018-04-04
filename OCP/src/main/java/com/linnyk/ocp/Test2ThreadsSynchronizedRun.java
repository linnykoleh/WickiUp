package com.linnyk.ocp;

public class Test2ThreadsSynchronizedRun extends Thread {

	int x, y;

	private Test2ThreadsSynchronizedRun(String name) {
		super(name);
	}

	@Override
	public synchronized void run() {
		for(;;){
			x++;
			y++;
			System.out.println(Thread.currentThread().getName() + ": " + x + " " + y);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {}
		}
	}

	public static void main(String[] args) {
		new Test2ThreadsSynchronizedRun("Thread 1").start();
		new Test2ThreadsSynchronizedRun("Thread 2").start();

		/*

			Thread 1: 1 1
			Thread 2: 1 1
			Thread 1: 2 2
			Thread 2: 2 2
			Thread 1: 3 3
			Thread 2: 3 3
			Thread 1: 4 4
			Thread 2: 4 4
			Thread 1: 5 5
			Thread 2: 5 5
			Thread 1: 6 6
			Thread 2: 6 6
			Thread 1: 7 7
			Thread 2: 7 7

			У каждого потока свое значение X и Y и они не синхронизированны

			public synchronized void run() - не помогает
		*/
	}
}
