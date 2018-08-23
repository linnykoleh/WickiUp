package com.linnyk.ocp.concurrency.course_1.livelock;

public class LiveLock {

	private static final Полиция ПОЛИЦИЯ = new Полиция();
	private static final Преступник ПРЕСТУПНИК = new Преступник();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				ПОЛИЦИЯ.датьВзятку(ПРЕСТУПНИК);
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				ПРЕСТУПНИК.освободитьЗаложника(ПОЛИЦИЯ);
			}
		});
		t2.start();
	}

}
