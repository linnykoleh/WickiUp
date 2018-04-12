package com.linnyk.ocp;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantExample {

	public static void main(String[] args) {
		final Instant nowUTC = Instant.now();
		System.out.println(nowUTC); // 2018-04-12T09:06:39.595Z. С UTC у нас 3 часа разницы
		                            // Instant всегда показывает вреся в UTC

		final LocalDateTime now = LocalDateTime.now();
		System.out.println(now);    // 2018-04-12T11:08:18.268
	}
}
