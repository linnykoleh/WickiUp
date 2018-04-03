package com.linnyk.ocp;

import java.time.*;

public class PeriodDuration {

    public static void main(String[] args) {

        final LocalDateTime localDateTimeNow = LocalDateTime.of(2015, Month.SEPTEMBER, 2, 1, 0, 0);
        final LocalDate localDateNow = LocalDate.of(2015, Month.SEPTEMBER, 2);

        Period p = Period.between(localDateNow, LocalDate.of(2015, Month.SEPTEMBER, 1));
        System.out.println(p); //P-1D
         /*Первое сентября первее второго сентября, вот почему P-1D*/

        Duration d = Duration.between(localDateTimeNow, LocalDateTime.of(2015, Month.SEPTEMBER, 2, 10, 10));
        System.out.println(d); //PT9H10M

        Duration d1 = Duration.between(LocalDateTime.now(), LocalDateTime.of(2015, Month.SEPTEMBER, 2, 10, 10));
        System.out.println(d1); //PT-22666H-43M-2.398S
    }
}
