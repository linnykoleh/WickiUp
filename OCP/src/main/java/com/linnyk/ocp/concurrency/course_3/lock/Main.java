package com.linnyk.ocp.concurrency.course_3.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

	public static void main(String[] args) {

		final SharedResource sharedResource = new SharedResource();
		for (int i = 0; i < 3; i++) {
			new MyThread(sharedResource, i).start();
		}
	}

	static class SharedResource{

		private final Lock lock = new ReentrantLock();

		public void doStuff(){
			try {
				lock.lock();
				final String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " working");
				Thread.sleep(3000);
				System.out.println(threadName + " finished work");
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}

		}
	}

	static class MyThread extends Thread{

		private SharedResource sharedResource;

		public MyThread(SharedResource sharedResource, int i) {
			this.setName("Thread " + i);
			this.sharedResource = sharedResource;
		}

		@Override
		public void run() {
			final String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " is going to do stuff");
			sharedResource.doStuff();
		}
	}

}
