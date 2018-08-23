package com.linnyk.ocp.concurrency.course_3.phaser._1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class Bus {

    private static final Phaser PHASER = new Phaser(1);//Сразу регистрируем главный поток
    //Фазы 0 и 6 - это автобусный парк, 1 - 5 остановки

    public static void main(String[] args) throws InterruptedException {
        final List<Passenger> passengers = new ArrayList<>();

        for (int departure = 1; departure < 5; departure++) {           //Сгенерируем пассажиров на остановках
            Thread.sleep(2000);
            if ((int) (Math.random() * 2) > 0) {
                passengers.add(new Passenger(departure, departure + 1, PHASER));//Этот пассажир выходит на следующей
            }

            if ((int) (Math.random() * 2) > 0) {
                passengers.add(new Passenger(departure, 5, PHASER));    //Этот пассажир выходит на конечной
            }
        }

        for (int i = 0; i < 7; i++) {
            Thread.sleep(2000);
            switch (i) {
                case 0:
                    System.out.println("Автобус выехал из парка.");
                    PHASER.arrive();//В фазе 0 всего 1 участник - автобус
                    break;
                case 6:
                    System.out.println("Автобус уехал в парк.");
                    PHASER.arriveAndDeregister();//Снимаем главный поток, ломаем барьер
                    break;
                default:
                    int currentBusStop = PHASER.getPhase();
                    System.out.println("Остановка № " + currentBusStop);

                    for (Passenger p : passengers) {          //Проверяем, есть ли пассажиры на остановке
                        if (p.departure == currentBusStop) {
                            PHASER.register();//Регистрируем поток, который будет участвовать в фазах
                            p.start();        // и запускаем
                        }
                    }
                    PHASER.arriveAndAwaitAdvance();//Сообщаем о своей готовности
            }
        }
    }
}
