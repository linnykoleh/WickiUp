package com.linnyk.ocp.concurrency.course_3.lock.reentrant_read_write_lock;

import static java.lang.Thread.sleep;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		final ExecutorService executor = Executors.newFixedThreadPool(10);
		final ReadWriteLock lock = new ReentrantReadWriteLock();

		final Runnable writeTask = () -> {
			lock.writeLock().lock();
			try {
				System.out.println("WriteTask is locked");
				sleep(2000);
				System.out.println("WriteTask is unlocked");
			}
			catch (InterruptedException e) {}
			finally {
				lock.writeLock().unlock();
			}
		};

		final Runnable readTask = () -> {
			lock.readLock().lock();
			try {
				System.out.println("ReadTask is locked");
				sleep(2000);
				System.out.println("ReadTask is unlocked");
			}
			catch (InterruptedException e) {}
			finally {
				lock.readLock().unlock();
			}
		};

		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(writeTask);
		executor.submit(readTask);
		executor.submit(readTask);

		executor.shutdown();
	}
}
