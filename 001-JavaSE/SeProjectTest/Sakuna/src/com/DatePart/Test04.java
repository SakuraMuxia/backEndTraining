package com.DatePart;

import java.time.LocalDate;

public class Test04 {
    public static void main(String[] args) {
        // 通过now静态方法 创建LocalDate对象
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate1 = " + localDate); // localDate = 2025-07-21

        // 通过of 静态方法 创建LocalDate对象
        LocalDate of = LocalDate.of(2024,12,12); // localDate2 = 2024-12-12
        System.out.println("localDate2 = " + of);

        // 获取年月日信息
        int year = of.getYear();
        System.out.println("year = " + year);
    }
}
