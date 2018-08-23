package com.linnyk.ocp.concurrency.ocp._1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AnyNumberBetween {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        Stream<String> stream = Stream.of("old", "king", "cole", "was", "a", "merry", "old", "soul").parallel();
        stream.filter( e->{
            ai.incrementAndGet();
            return e.contains("o"); }).allMatch(x->x.indexOf("o")>0);
        System.out.println("AI = "+ai);
    }
}
