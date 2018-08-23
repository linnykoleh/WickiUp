package com.linnyk.ocp.concurrency.course_1.lifecycle_threads;


public class ThreadLifecycleJoin {

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
		MyThread3 myThread = new MyThread3();
		myThread.start();
		myThread.join(); //механизм, позволяющий одному потоку ждать завершения выполнения другого. Main поток будет ждать когда закончится myThread поток
		System.out.println("main");
	}
}

class MyThread3 extends Thread {

	@Override
	public void run() {
		System.out.println("thread 0");
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

