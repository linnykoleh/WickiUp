package com.linnik.wickiup.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Tests {

    public static void main(String[] args) throws InterruptedException {
        Disposable subscribe = Observable
                .range(5, 3)
                .subscribe(Tests::log);


        System.out.println("================================");
        Observable<BigInteger> naturalNumbers = Observable.create(
                subscriber -> {
                    Runnable r = () -> {
                        BigInteger i = BigInteger.ZERO;
                        while (!subscriber.isDisposed()) {
                            subscriber.onNext(i);
                            i = i.add(BigInteger.ONE);
                        }
                    };
                    new Thread(r).start();
                });
        Disposable subscribe1 = naturalNumbers.subscribe(integer -> System.out.println(Thread.currentThread().getName() + " " + integer));
        Thread.sleep(10);
        subscribe1.dispose();

        System.out.println("================================");

        Observable
                .timer(1, TimeUnit.SECONDS)
                .subscribe(Tests::log);
        Thread.sleep(2200);

        System.out.println("================================");

        Observable
                .interval(1, SECONDS)
                .subscribe(Tests::log);
        Thread.sleep(2000);

        System.out.println("================================");

        Observable<Integer> delayed = delayed(1);
        Disposable subscribe2 = delayed.subscribe(Tests::log);
        Thread.sleep(2000);
        subscribe2.dispose();

        System.out.println("================================");
    }

    private static void log(Object obj) {
        System.out.println(Thread.currentThread().getName() + " " + obj);
    }

    static <T> Observable<T> delayed(T x) {
        return Observable.create(
                subscriber -> {
                    Runnable r = () -> {/*  ...  */};
                    final Thread thread = new Thread(r);
                    thread.start();
                    subscriber.setDisposable(Disposable.fromRunnable(new Runnable() {
                        @Override
                        public void run() {
                            thread.interrupt();
                        }
                    }));
                });
    }

}
