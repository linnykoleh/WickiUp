package com.linnyk.java9.flow;

public class FlowApp {

    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.subscribe(new Subscriber());

        publisher.sendMessagesAsync("123");
    }
}
