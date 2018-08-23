package com.linnyk.ocp.concurrency.course_3.phaser._2;

import java.util.concurrent.Phaser;

public class ThreadsApp {

    public static void main(String[] args) throws InterruptedException {

        final Phaser phaser = new Phaser(1);

        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        Thread.sleep(100);
        int phase = phaser.getPhase();
        System.out.println("Ждем завершения " + phase + " фазы");
        phaser.arriveAndAwaitAdvance(); // ждем завершения фазы 0
        System.out.println("Фаза " + phase + " завершена");

        Thread.sleep(100);
        phase = phaser.getPhase();
        System.out.println("Ждем завершения " + phase + " фазы");
        phaser.arriveAndAwaitAdvance(); // ждем завершения фазы 1
        System.out.println("Фаза " + phase + " завершена");

        Thread.sleep(100);
        phase = phaser.getPhase();
        System.out.println("Ждем завершения " + phase + " фазы");
        phaser.arriveAndAwaitAdvance(); // ждем завершения фазы 2
        System.out.println("Фаза " + phase + " завершена");

        //сообщает о завершении всех фаз стороной и снимает ее с регистрации.
        phaser.arriveAndDeregister();
    }
}

class PhaseThread implements Runnable{

    Phaser phaser;
    String name;

    PhaseThread(Phaser phaser, String name){
        this.phaser = phaser;
        this.name = name;
        // регистрирует сторону, которая выполняет фазы, и возвращает номер текущей фазы - обычно фаза 0
        this.phaser.register();
    }

    @Override
    public void run(){
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        sleep(4000);
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута

        sleep(1000);
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        sleep(4000);
        phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута

        sleep(1000);
        System.out.println(name + " выполняет фазу " + phaser.getPhase());

        //сообщает о завершении всех фаз стороной и снимает ее с регистрации.
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты

    }

    private void sleep(long timeout) {
        try{
            Thread.sleep(timeout);
        }catch(InterruptedException ex){}
    }
}