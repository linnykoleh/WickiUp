package com.linnyk.ocp.concurrency.course_1.scheduled_executor_service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

		scheduledExecutorService.schedule(new MyThread(), 2, TimeUnit.SECONDS);
	}

	static class MyThread extends Thread{

		@Override
		public void run() {
			System.out.println(1);
		}
	}
}
