package com.linnyk.ocp.concurrency.course_3.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SheepManager {

	private AtomicInteger sheepCount = new AtomicInteger(0);
	private AtomicReference<MyObject> myObjectAtomicReference = new AtomicReference(new MyObject("First"));

	private void incrementAndReport() {
		System.out.print((sheepCount.incrementAndGet())+" ");
		System.out.println(myObjectAtomicReference.getAndSet(new MyObject("Second")));
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SheepManager manager = new SheepManager();
			for(int i=0; i<10; i++) {
				service.submit(() -> manager.incrementAndReport());
			}
		} finally {
			if(service != null) service.shutdown();
		}
	}
}

class MyObject{

	public String value;

	public MyObject(String value) {
		this.value = value;
	}
}