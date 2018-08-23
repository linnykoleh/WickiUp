package com.linnyk.ocp.concurrency.course_3.java_interaction;

public class Chat {

	boolean flag = false;

	public synchronized void question(String msg) {
		if (flag) {
			try {
				Thread.sleep(1000);
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println("Q: " + msg);
		flag = true;
		notify();
	}

	public synchronized void answer(String msg) {
		if (!flag) {
			try {
				Thread.sleep(1000);
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println("A: " + msg);
		flag = false;
		notify();
	}

}