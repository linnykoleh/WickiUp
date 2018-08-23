package com.linnyk.ocp.concurrency.course_1.exchenger;

import java.time.LocalDate;
import java.util.concurrent.Exchanger;

public class Main {

	/**
	 	Передача сообщений между потоками
	 */

	public static void main(String[] args) {
		final Exchanger<LocalDate> exchanger = new Exchanger<>();

		new Mike(exchanger).start();
		new Lila(exchanger).start();
	}

	static class Mike extends Thread{
		Exchanger<LocalDate> exchanger;

		public Mike(Exchanger<LocalDate> exchanger) {
			this.exchanger = exchanger;
			setName("Mike");
		}

		@Override
		public void run() {
			try {
				final LocalDate now = LocalDate.now();
				System.out.println("Mike said: " + now);
				sleep(2000);
				final LocalDate answer = exchanger.exchange(now);
				System.out.println("The answer from Lila is " + answer);
			}
			catch (InterruptedException e) {}
		}
	}

	static class Lila extends Thread{
		Exchanger<LocalDate> exchanger;

		public Lila(Exchanger<LocalDate> exchanger) {
			this.exchanger = exchanger;
			setName("Lila");
		}

		@Override
		public void run() {
			try {
				final LocalDate yesterday = LocalDate.now().minusDays(1);
				System.out.println("Lila said: " + yesterday);
				final LocalDate answer = exchanger.exchange(yesterday);
				System.out.println("The answer from Mike is " + answer);
				sleep(3000);
			}
			catch (InterruptedException e) {}
		}
	}
}
