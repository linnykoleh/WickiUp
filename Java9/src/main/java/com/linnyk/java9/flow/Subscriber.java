package com.linnyk.java9.flow;

import com.linnyk.java9.flow.message.Message;

import java.util.concurrent.Flow;

public class Subscriber implements Flow.Subscriber<Message> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("onSubscribe: " + subscription);
        this.subscription = subscription;
        this.subscription.request(1); //  Ask for initial one data object.
    }

    @Override
    public void onNext(Message item) {
        System.out.println("onNext: " + item);
        this.subscription.request(1); // Ask for one more.
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError: " + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }

}
