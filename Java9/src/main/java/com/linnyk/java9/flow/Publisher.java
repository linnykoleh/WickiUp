package com.linnyk.java9.flow;

import com.linnyk.java9.flow.message.Message;

import java.util.concurrent.SubmissionPublisher;

public class Publisher {

    private SubmissionPublisher<Message> sb = new SubmissionPublisher<>();

    public void sendMessagesAsync(String message) {
        sb.submit(new Message(message));
        System.out.println("Send message: " + message);
    }

    public void subscribe(Subscriber subscriber) {
        sb.subscribe(subscriber);
    }
}
