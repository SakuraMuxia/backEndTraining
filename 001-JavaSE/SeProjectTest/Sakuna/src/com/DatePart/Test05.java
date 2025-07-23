package com.DatePart;

import java.time.LocalTime;

public class Test05 {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime); // localTime = 17:11:09.412

        LocalTime localTime1 = LocalTime.of(17, 30, 00);
        System.out.println("localTime1 = " + localTime1); // localTime1 = 17:30

        int hour = localTime1.getHour();
        System.out.println("hour = " + hour); // hour = 17
    }
}
