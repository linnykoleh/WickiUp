package com.linnyk.ocp.concurrency.course_1.phaser;

import java.util.concurrent.Phaser;

public class Main {

	/**

	 Поочереди каждый поток выполняет свою работу
	 */

	public static void main(String[] args) {
		Phaser phaser = new Phaser(2);

		new Washer(phaser);
		new Washer(phaser);
	}

	static class Washer extends Thread{
		Phaser phaser;

		public Washer(Phaser phaser) {
			this.phaser = phaser;
			start();
		}

		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(getName() + " is washing the car");
			}
			phaser.arriveAndAwaitAdvance();
		}
	}
}
