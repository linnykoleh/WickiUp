package com.linnyk.ocp.concurrency.course_3.atomic;

import java.util.concurrent.atomic.DoubleAccumulator;

public class AtomicAccumulatorExample {

    private static final DoubleAccumulator da = new DoubleAccumulator((left, right) -> left + right, 0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i1 = 0; i1 < 10; i1++) {
                da.accumulate(i1);
                System.out.println("Adding " + i1);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i1 = 0; i1 < 10; i1++) {
                da.accumulate(i1);
                System.out.println("Adding " + i1);
            }
        });
        thread1.start();
        thread2.start();
        try {
            System.out.println("Sleep while summing....");
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
        System.out.println("The sum is: " + da.doubleValue());
    }
}
