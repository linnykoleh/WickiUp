package com.linnyk.ocp;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ZonedLocalDateTime {

	public static void main(String[] args) {
		LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
		System.out.println(ld1); // 2015-11-01T02:00
		ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
		System.out.println(zd1); // 2015-11-01T02:00-05:00[US/Eastern]

		LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
		System.out.println(ld2); // 2015-11-01T01:00
		ZonedDateTime zd2 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
		System.out.println(zd2); // 2015-11-01T02:00-05:00[US/Eastern]

		System.out.println(ChronoUnit.HOURS.between(zd1, zd2)); // 0
	}
}
