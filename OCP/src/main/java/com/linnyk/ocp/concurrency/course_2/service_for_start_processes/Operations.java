package com.linnyk.ocp.concurrency.course_2.service_for_start_processes;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Operations {

	private final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		final Account a = new Account(1000);
		final Account b = new Account(2000);
		
		for (int i = 0; i < 10; i++) {
			Future<Boolean> submit = EXECUTOR_SERVICE.submit(new Transfer(i, a, b, new Random().nextInt(400)));
			System.out.println(submit.get());
		}

		EXECUTOR_SERVICE.shutdown();
	}



}