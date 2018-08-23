package com.linnyk.ocp.concurrency.course_1.thread_local;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    /**
        - Для многопоточных приложений если нужно получить рандомноек число лучше использовать ThreadLocalRandom
        -
     */

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ThreadLocalRandom.current().nextInt()); // получить рандомное число

        System.out.println(TimeUnit.DAYS.toSeconds(1)); //получение секунд, миллисекунд ....  из дней, часов ...
    }
}
