package com.linnyk.ocp.concurrency.course_1.synchronization;


public class Main {

	public static void main(String[] args) throws InterruptedException {

		/**
		 synchronized имеет два важных момента: это гарантия того, что только один поток выполняет секцию кода в один момент времени (взаимоисключение или mutex),
		 и также гарантия того, что данные, изменённые одним потоком, будут видны всем другим потокам (видимость изменений).

		 В качестве лока для synchronized метода выступает сам объект Resources
		 */

		final Resources resources = new Resources();
		resources.i = 5;

		final MyThread myThread = new MyThread();
		final MyThread myThread1 = new MyThread();

		myThread.setName("one");

		myThread.setResources(resources);
		myThread1.setResources(resources);

		myThread.start();
		myThread1.start();

		myThread.join();
		myThread1.join();

		System.out.println(resources.i);
	}
}

class MyThread extends Thread {

	Resources resources;

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	@Override
	public void run() {
		resources.changeI();
	}
}

class Resources{

	int i;

	public synchronized void changeI(){ //synchronized На методе
		int i = this.i;
		if(Thread.currentThread().getName().equals("one")){
			Thread.yield();
		}
		i++;
		this.i = i;
	}

	public void changeI2() {
		synchronized (this){ //synchronized блок
			int i = this.i;
			if(Thread.currentThread().getName().equals("one")){
				Thread.yield();
			}
			i++;
			this.i = i;
		}
	}
}
