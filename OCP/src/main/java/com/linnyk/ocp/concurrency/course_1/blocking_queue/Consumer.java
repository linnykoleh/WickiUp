package com.linnyk.ocp.concurrency.course_1.blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(1000);
                queue.take();
                System.out.println("Consumer took");
            }
        } catch (InterruptedException e) {}
    }
}
