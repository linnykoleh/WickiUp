package com.linnyk.ocp.concurrency.course_1.thread_factory;

import java.util.concurrent.ThreadFactory;

public class Main {

    /**
        Just фабрика для работы с потоками
     */

    public static void main(String[] args) {
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread();
            thread.setPriority(Thread.MAX_PRIORITY);
            return thread;
        };

        threadFactory.newThread(new MyRunnable()).start();
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("MyRunnable");
        }
    }
}
