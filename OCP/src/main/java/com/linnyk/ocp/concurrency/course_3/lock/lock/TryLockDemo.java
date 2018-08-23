package com.linnyk.ocp.concurrency.course_3.lock.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo implements Task {

	final private ReentrantLock reentrantLock = new ReentrantLock();
	@Override
	public void performTask() {
		try {
			System.out.println(Thread.currentThread().getName() +": trying get lock");
			boolean flag = reentrantLock.tryLock(6000, TimeUnit.MILLISECONDS);
			if (flag) {
				try {
					System.out.println(Thread.currentThread().getName() +": lock");
					System.out.println(Thread.currentThread().getName() + " processing...");
					Thread.sleep(5000);
				} finally {
					System.out.println(Thread.currentThread().getName() +": unlock");
					reentrantLock.unlock();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}