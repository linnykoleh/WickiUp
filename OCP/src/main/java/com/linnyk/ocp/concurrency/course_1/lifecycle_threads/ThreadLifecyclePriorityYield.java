package com.linnyk.ocp.concurrency.course_1.lifecycle_threads;


public class ThreadLifecyclePriorityYield {

	/**                     +--------------------------+
	                        | Waiting/Blocking/Sleeping|
	                        +--------------------------+
	                              /          *
	                            /             \
	                          *                \
	     +-----+         +--------+          +---------+        +------+
	     | New |   ---*  |Runnable|    ---*  | Running |  ---*  | Dead |
	     +-----+         |(в пуле)|          +---------+        +------+
                         +--------+
	 */

	public static void main(String[] args) throws Exception {
		MyThread2 myThread = new MyThread2();
		myThread.start();
		myThread.setPriority(Thread.NORM_PRIORITY); // от 0 до 10. Приоритет потоков, одни выполняются чаще, чем остальные
		Thread.yield(); //заставляет процессор переключиться на обработку других потоков системы. меняет состояние потока из running в runnable.
		System.out.println("main");
	}
}

class MyThread2 extends Thread {

	@Override
	public void run() {
		System.out.println("thread 0");
	}
}

