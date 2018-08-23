package com.linnyk.ocp.concurrency.course_1.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		/**

		 Thread pool - пул потоков, потоки переиспользуются, если поток закончился, он используется для другой работы

		 */
		final ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(new MyRunnable());
		System.out.println(executorService.submit(new MyCallable()).get());

		executorService.shutdownNow();
	}

	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			System.out.println(1);
		}
	}

	static class MyCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			return "2";
		}
	}
}
