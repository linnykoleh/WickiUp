package com.linnyk.ocp;

public class Test2Threads extends Thread {

	static Object object = new Object();

	static int x, y;

	private Test2Threads(String name) {
		super(name);
	}

	@Override
	public void run() {
		synchronized (object){
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
	}

	public static void main(String[] args) {
		new Test2Threads("Thread 1").start();
		new Test2Threads("Thread 2").start();

		/*
		    Thread 1: 1 1
			Thread 1: 2 2
			Thread 1: 3 3
			Thread 1: 4 4
			Thread 1: 5 5
			Thread 1: 6 6
			Thread 1: 7 7
			Thread 1: 8 8

		*/
	}
}
