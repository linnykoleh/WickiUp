package com.linnyk.ocp.concurrency.course_1.conditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int account = 0;

    public static void main(String[] args) {
        new AccountMinus().start();
        new AccountPlus().start();
    }

    static class AccountPlus extends Thread{

        @Override
        public void run() {
            lock.lock();
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {}
            account += 10;
            System.out.print("After 3 sec account");
            System.out.println(" updated to " + account);
            System.out.println("SIGNAL");
            condition.signal();
            lock.unlock();
        }
    }

    static class AccountMinus extends Thread{

        @Override
        public void run() {
            lock.lock();
            if (account < 10) {
                try {
                    System.out.print("Before waiting");
                    System.out.println(" account is " + account);
                    System.out.println("WAITING");
                    condition.await();
                    System.out.print("After waiting");
                    System.out.println(" account is " + account);
                } catch (InterruptedException e) {
                }
                account -= 10;
            }
            lock.unlock();
        }
    }
}
