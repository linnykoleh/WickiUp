package com.linnyk.ocp.concurrency.course_1.synchronization_volatile;


public class VolatileMain {

	/**

	 volatile подходит только для контроля доступа к одиночному экземпляру или переменной примитивного типа: int, boolean...
	 Когда переменная объявлена как volatile, любая запись её будет осуществляться прямо в память, минуя кеш.
	 Также как и считываться будет прямо из памяти, а не из всевозможного кеша.
	 Это значит, что все потоки будут "видеть" одно и то же значение переменной одновременно.

	 */

	volatile static int i;

	public static void main(String[] args) {
		new MyThreadRead().start();
		new MyThreadWrite().start();
	}

	static class MyThreadWrite extends Thread {

		@Override
		public void run() {
			while(i < 5){
				System.out.println("increment i to " + (++i));
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {}
			}
		}
	}

	static class MyThreadRead extends Thread {

		@Override
		public void run() {
			int localVar = i;
			while(localVar < 5){
				if(localVar != i) {
					System.out.println("new value of i is " + i);
					localVar = i;
				}
			}
		}
	}
}
