package com.linnyk.ocp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DayLightSaving {

    public static void main(String[] args) {
        _1();
        System.out.println("-----------------------------");
        _2();
        System.out.println("-----------------------------");
        _3();
        System.out.println("-----------------------------");
        _4();
        System.out.println("-----------------------------");
        _5();
        System.out.println("-----------------------------");
        _6();
        System.out.println("-----------------------------");
        _7();
    }

    private static void _1() {
        LocalDateTime ld1 = LocalDateTime.of(2015, Month.MARCH, 8, 2, 0);
        System.out.println(ld1); //2015-03-08T02:00
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
        System.out.println(zd1); //2015-03-08T03:00-04:00[US/Eastern]

        LocalDateTime ld2 = LocalDateTime.of(2015, Month.MARCH, 8, 3, 0);
        System.out.println(ld2); //2015-03-08T03:00
        ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
        System.out.println(zd2); //2015-03-08T03:00-04:00[US/Eastern]

        System.out.println(ChronoUnit.HOURS.between(zd1, zd2)); // 0
    }

    private static void _2() {
        LocalDateTime ld1 = LocalDateTime.of(2015, Month.MARCH, 8, 2, 0);
        System.out.println(ld1); // 2015-03-08T02:00
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
        System.out.println(zd1); // 2015-03-08T03:00-04:00[US/Eastern]
    }

    private static void _3() {
        LocalDateTime ld1 = LocalDateTime.of(2017, Month.MARCH, 26, 3, 00,0);
        System.out.println(ld1); //2017-03-26T03:00
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("Europe/Kiev"));
        System.out.println(zd1); //2017-03-26T04:00+03:00[Europe/Kiev]
    }

    private static void _4() {
        LocalDateTime ld1 = LocalDateTime.of(2017, Month.OCTOBER, 29, 4, 00,0);
        System.out.println(ld1); // 2017-10-29T04:00
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("Europe/Kiev"));
        System.out.println(zd1); // 2017-10-29T04:00+02:00[Europe/Kiev]
    }

    private static void _5() {
        LocalDateTime ldtAt3 = LocalDateTime.of(2015, Month.OCTOBER, 25, 3, 0);
        System.out.println(ldtAt3); //2015-10-25T03:00
        ZonedDateTime zdtAt3= ZonedDateTime.of(ldtAt3, ZoneId.of("EET"));
        System.out.println(zdtAt3); //2015-10-25T03:00+03:00[EET]

        System.out.println("====");

        LocalDateTime ldtAt4 = LocalDateTime.of(2015, Month.OCTOBER, 25, 3, 0);
        System.out.println(ldtAt4); //2015-10-25T03:00
        ZonedDateTime zdtAt4 = ZonedDateTime.of(ldtAt4, ZoneId.of("EET"));
        System.out.println(zdtAt4); //2015-10-25T03:00+03:00[EET]
    }

    private static void _6() {
        LocalDateTime ldt = LocalDateTime.of(2016, Month.MARCH, 14, 5, 0);
        ZonedDateTime end= ZonedDateTime.of(ldt, ZoneId.of("-04:00"));
        System.out.println(end); //2016-03-14T05:00-04:00

        LocalDateTime ldt2 = LocalDateTime.of(2016, Month.MARCH, 14, 9, 0);
        ZonedDateTime start= ZonedDateTime.of(ldt2, ZoneId.of("+01:00"));
        System.out.println(start); //2016-03-14T09:00+01:00

        System.out.println(Duration.between(end, start)); // PT-1H
        System.out.println(Duration.between(start, end)); // PT1H
    }

    private static void _7() {
        LocalDateTime ldt = LocalDateTime.of(2016, Month.MARCH, 14, 7, 0);
        ZonedDateTime end= ZonedDateTime.of(ldt, ZoneId.of("-05:00"));
        System.out.println(end); //2016-03-14T07:00-05:00

        LocalDateTime ldt2 = LocalDateTime.of(2016, Month.MARCH, 14, 8, 0);
        ZonedDateTime start= ZonedDateTime.of(ldt2, ZoneId.of("+06:00"));
        System.out.println(start); //2016-03-14T08:00+06:00

        System.out.println(Duration.between(end, start)); // PT-10H
        System.out.println(Duration.between(start, end)); // PT10H
    }
}
