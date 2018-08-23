package com.linnyk.ocp.concurrency.course_3.lock.starvation;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadStarvationExample {

    private final static Object mutex = new Object();
    private final static AtomicBoolean isActive = new AtomicBoolean(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(), "Thread_1_P10");
        Thread t3 = new Thread(new Worker(), "Thread_3_P6");
        Thread t5 = new Thread(new Worker(), "Thread_5_P2");

        t1.setPriority(10);
        t3.setPriority(6);
        t5.setPriority(2);

        t1.start();
        t3.start();
        t5.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        isActive.set(false);
    }

    static class Worker implements Runnable {

        private int runCount;

        public void run() {
            // tight loop using volatile variable as active flag for proper shutdown
            while (isActive.get()) {
                synchronized (mutex) {
                    try {
                        Thread.sleep(1000);
                        doWork();
                    } catch (Exception e) {}
                }
            }
            System.out.format("DONE %s: Current runCount is %d...\n", Thread.currentThread().getName(), runCount);
        }

        private void doWork() {
            System.out.format("%s: Current runCount is %d...\n", Thread.currentThread().getName(), ++runCount);
        }
    }

}


