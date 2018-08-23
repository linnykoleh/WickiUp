package com.linnyk.ocp.concurrency.course_1.lifecycle_threads;


public class ThreadLifecycle {

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
		MyThread myThread = new MyThread();
		myThread.start();
		Thread.sleep(1000); //состояние изменяется с running на waiting/sleeping.
		System.out.println("thread main");
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("thread 0");
	}
}
