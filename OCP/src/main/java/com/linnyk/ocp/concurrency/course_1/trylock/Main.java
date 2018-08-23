package com.linnyk.ocp.concurrency.course_1.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread2().start();
    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " start working");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
            System.out.println(getName() + " stop working");
            lock.unlock();
            System.out.println("lock is release");
        }
    }

    static class MyThread2 extends Thread{

        @Override
        public void run() {
            System.out.println(getName() + " start work");
            while (true) {
                if(lock.tryLock()){
                    System.out.println(getName() + " working");
                    break;
                }else {
                    System.out.println(getName() + " sleeping");
                }
            }
        }
    }

}
