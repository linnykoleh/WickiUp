package com.linnyk.ocp;

public class ForThread extends Thread {

	private static int threadCounter = 0;

	@Override
	public void run() {
		threadCounter++;
		System.out.println(threadCounter);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			synchronized (ForThread.class){
				new ForThread().start();
			}
		}
	}
	// 2
	// 3
	// 2
	// 4
	// 6
	// 5
	// 7
	// 9
	// 8
	// 10

	//Different result
}
