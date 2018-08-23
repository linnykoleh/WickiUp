package com.linnyk.ocp.concurrency.course_3.fork_join;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class CounterMain {

    public static void main(String[] args) {
        Node root = getRootNode();
        final ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        final ValueSumCounter task = new ValueSumCounter(root);
        final Long result = forkJoinPool.invoke(task);
        System.out.println(result);
    }

    private static Node getRootNode() {
        Node _12 = new Node(12);
        Node _11 = new Node(11);
        Node _10 = new Node(10);
        Node _9 = new Node(9);
        Node _8 = new Node(8);
        Node _7 = new Node(7);
        Node _6 = new Node(6);
        Node _5 = new Node(5);
        Node _4 = new Node(4);
        Node _3 = new Node(3);
        Node _2 = new Node(2);

        return new Node(1, Arrays.asList(_2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12));
    }
}
