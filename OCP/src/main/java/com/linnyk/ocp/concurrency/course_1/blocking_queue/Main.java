package com.linnyk.ocp.concurrency.course_1.blocking_queue;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

//        new Consumer(queue).start();
//        new Supplier(queue).start();

        List<Integer> ls = Arrays.asList(1, 2, 3);
        double sum = ls.stream().reduce(0, (a, b)->a+b);
        System.out.println(sum);

//        Supplier added
//        Supplier added
//        Supplier added
//        Supplier added
//        Supplier added
//        Consumer took
//        Supplier added
//        Consumer took
//        Supplier added
//        Consumer took
//        Supplier added
//        Consumer took
//        Supplier added
//        Consumer took
//        Supplier added
//        Consumer took
//        Supplier added
//        Consumer took
//        Supplier added
//        Consumer took
//        Supplier added
    }
}
