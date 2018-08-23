package com.linnyk.ocp.concurrency.course_3.lock.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyDemo implements Task {

	final private ReentrantLock reentrantLock = new ReentrantLock();
	private boolean flag = false;

	@Override
	public void performTask() {
		try {
			reentrantLock.lockInterruptibly();
			// если он не может получить блокировку из-за других прерываний потоков,
			// будет вызван InterruptedException, и управление перейдет в блок catch.
			try {
				System.out.println(Thread.currentThread().getName() + ": lock");
				System.out.println(Thread.currentThread().getName() +  ": processing...");
				Thread.sleep(2000);
				flag = true;
			}
			finally {
				System.out.println(Thread.currentThread().getName() + ": unlock");
				reentrantLock.unlock();
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
