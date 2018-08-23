package com.linnyk.ocp.concurrency.course_1.reentrantlock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		/**
		 	ReentrantLock более гибкая синхронизация
		 */

		final Resources resources = new Resources();
		resources.i = 5;

		final MyThread myThread = new MyThread();
		final MyThread myThread1 = new MyThread();

		myThread.setName("one");

		myThread.setResources(resources);
		myThread1.setResources(resources);

		myThread.start();
		myThread1.start();

		myThread.join();
		myThread1.join();

		System.out.println(resources.i);
	}
}

class MyThread extends Thread {

	Resources resources;

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	@Override
	public void run() {
		resources.changeI();
	}
}

class Resources{

	int i;

	Lock lock = new ReentrantLock();

	public void changeI(){
		lock.lock();
		int i = this.i;
		if(Thread.currentThread().getName().equals("one")){
			Thread.yield();
		}
		i++;
		this.i = i;
		lock.unlock();
	}

}
