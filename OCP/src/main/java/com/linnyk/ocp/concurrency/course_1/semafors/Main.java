package com.linnyk.ocp.concurrency.course_1.semafors;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		final Semaphore table =  new Semaphore(2);

		Person person = new Person();
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		Person person4 = new Person();
		Person person5 = new Person();
		Person person6 = new Person();

		person.table = table;
		person1.table = table;
		person2.table = table;
		person3.table = table;
		person4.table = table;
		person5.table = table;
		person6.table = table;

		person.start();
		person1.start();
		person2.start();
		person3.start();
		person4.start();
		person5.start();
		person6.start();
	}

	static class Person extends Thread{
		Semaphore table;

		@Override
		public void run() {
			System.out.println(this.getName() + " waiting");
			try {
				table.acquire();
				System.out.println(this.getName() + " acquire");
				Thread.sleep(5000);
				System.out.println(this.getName() + " release");
				table.release();
			}
			catch (InterruptedException e) {}

		}
	}
}
