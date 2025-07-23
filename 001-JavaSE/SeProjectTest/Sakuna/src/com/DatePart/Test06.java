package com.DatePart;

import java.time.LocalDateTime;

public class Test06 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime); // localDateTime = 2025-07-21T17:14:18.473

        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 12, 25, 18, 00, 00);
        System.out.println("localDateTime1 = " + localDateTime1); // localDateTime1 = 2025-12-25T18:00

        int hour = localDateTime1.getHour();
        System.out.println("hour = " + hour); // hour = 18
    }
}
