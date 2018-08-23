package com.linnyk.ocp.concurrency.course_1.blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Supplier extends Thread {

    private final BlockingQueue<String> queue;

    public Supplier(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                queue.put("String");
                System.out.println("Supplier added");
            }
        } catch (InterruptedException e) {}
    }
}
