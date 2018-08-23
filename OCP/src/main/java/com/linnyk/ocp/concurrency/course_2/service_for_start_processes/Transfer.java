package com.linnyk.ocp.concurrency.course_2.service_for_start_processes;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable<Boolean> {

    private final static long WAIT_SEC = 4;

    private int id;
    private Account acc1;
    private Account acc2;
    private int amount;

    public Transfer(int id, Account accountA, Account accountB, int amount) {
        this.id = id;
        this.acc1 = accountA;
        this.acc2 = accountB;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
         if(acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            System.out.println(id + " Locked acc1");
            try {
                if(acc1.getBalance() < amount){
                    throw new IllegalArgumentException();
                }
                if(acc2.getLock().tryLock()) {
                    System.out.println(id + " Locked acc2");
                    try {
                        acc1.withdraw(amount);
                        acc2.deposit(amount);
                        Thread.sleep(1000);
                        System.out.println(id + " Operations executed");
                    }finally {
                        acc2.getLock().unlock();
                        System.out.println(id + " UnLocked acc2");
                    }
                }else{
                    acc2.incFailedTransferCount();
                }
            }
            finally {
                acc1.getLock().unlock();
                System.out.println(id + " UnLocked acc2");
            }
            return true;
        }else{
            acc1.incFailedTransferCount();
            System.out.println(id + " Error waiting lock");
            return false;
        }
    }
}
