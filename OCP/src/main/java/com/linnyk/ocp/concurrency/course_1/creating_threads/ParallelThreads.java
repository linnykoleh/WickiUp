package com.linnyk.ocp.concurrency.course_1.creating_threads;


public class ParallelThreads {

	public static void main(String[] args) {
		new ParallelThread().start();
		new ParallelThread().start();
		new ParallelThread().start();
	}
}

class ParallelThread extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " i= " + i);
		}
	}
}

/*
Thread-0 i= 0
Thread-0 i= 1
Thread-0 i= 2
Thread-0 i= 3
Thread-0 i= 4
Thread-1 i= 0
Thread-1 i= 1
Thread-1 i= 2
Thread-1 i= 3
Thread-1 i= 4
Thread-2 i= 0
Thread-2 i= 1
Thread-2 i= 2
Thread-2 i= 3
Thread-2 i= 4
*/
