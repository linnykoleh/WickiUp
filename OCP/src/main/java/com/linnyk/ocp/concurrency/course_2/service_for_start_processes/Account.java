package com.linnyk.ocp.concurrency.course_2.service_for_start_processes;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private final Lock lock;

	private int balance;
	private AtomicInteger failCounter;

	public Account(int balance) {
		this.balance = balance;
		this.lock = new ReentrantLock();
	}

	public void withdraw(int amount) {
		this.balance -= amount;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}

	public int getBalance() {
		return balance;
	}

	public Lock getLock() {
		return lock;
	}

	public void incFailedTransferCount(){
		this.failCounter.incrementAndGet();
	}
	public int getFailCounter() {
		return failCounter.get();
	}
}
