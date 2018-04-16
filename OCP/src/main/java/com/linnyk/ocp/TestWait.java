package com.linnyk.ocp;

public class TestWait {

	public void doIt() throws InterruptedException {
		wait();
	}

	public static void main(String[] args) throws InterruptedException {
		new TestWait().doIt();

		/*

		Exception in thread "main" java.lang.IllegalMonitorStateException
			at java.lang.Object.wait(Native Method)
			at java.lang.Object.wait(Object.java:502)
			at com.linnyk.ocp.TestWait.doIt(TestWait.java:6)
			at com.linnyk.ocp.TestWait.main(TestWait.java:10)

		Чтобы пофиксить нужно добавить synchronized

		public synchronized void doIt() throws InterruptedException {
			wait();
		}

		*/
	}
}
