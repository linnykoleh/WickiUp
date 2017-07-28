package com.linnik.wickiup.patterns._1_creational._4_factory_method.live;

import java.util.Calendar;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) {
        final Calendar calendar = Calendar.getInstance();
        final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
    }
}
