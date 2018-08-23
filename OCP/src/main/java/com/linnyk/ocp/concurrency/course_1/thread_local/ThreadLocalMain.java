package com.linnyk.ocp.concurrency.course_1.thread_local;


public class ThreadLocalMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main started");

		ThreadOne threadOne = new ThreadOne();
		ThreadTwo threadTwo = new ThreadTwo();

		threadOne.start();
		threadTwo.start();

//		threadOne.join();
		threadTwo.join();

		System.out.println("Main finished");

	}


	static class ThreadOne extends Thread{

		@Override
		public void run() {
			System.out.println("ThreadOne started");
			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException e) {}
			System.out.println("ThreadOne finished");
		}
	}

	static class ThreadTwo extends Thread{

		@Override
		public void run() {
			System.out.println("ThreadTwo started");
			try {
				Thread.sleep(6000);
			}
			catch (InterruptedException e) {}
			System.out.println("ThreadTwo finished");
		}
	}




}
