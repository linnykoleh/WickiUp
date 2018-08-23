package com.linnyk.ocp.concurrency.course_1.fork_join_framework;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    final static long number = 10_000_000_000L;
    final static int numberOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println(new Date());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MyFork(0, number));
        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long>{

        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if(to - from <= number / numberOfThreads){
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            }else{
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1, to);
                secondHalf.fork();
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}
