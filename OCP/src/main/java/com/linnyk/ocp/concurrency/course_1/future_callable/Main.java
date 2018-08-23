package com.linnyk.ocp.concurrency.course_1.future_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final MyCallable myCallable = new MyCallable();
        final FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        final Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());
    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; j++, i++) {
                Thread.sleep(200);
            }
            return j;
        }
    }
}
