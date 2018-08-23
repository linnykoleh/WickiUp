package com.linnyk.ocp.concurrency.course_1.synchronized_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		NamedList namedList = new NamedList();
		namedList.add("first");

		class MyThread extends Thread{

			@Override
			public void run() {
				System.out.println(namedList.removeFirst());
			}
		}

		MyThread myThread = new MyThread();
		myThread.setName("one");
		myThread.start();

		new MyThread().start();
	}

	static class NamedList{
		private List<String> list = Collections.synchronizedList(new ArrayList<>());

		public void add(String name){
			list.add(name);
		}

		public synchronized String removeFirst(){
			if(!list.isEmpty()){
				if (Thread.currentThread().getName().equals("one")) {
					Thread.yield();
				}
				return list.remove(0);
			}
			return null;
		}
	}
}
