package com.DatePart;

import java.util.Calendar;

public class Test03 {
    public static void main(String[] args) {
        // 创建对象
        Calendar calendar = Calendar.getInstance();
        
        // 使用实例方法
        int year = calendar.get(Calendar.YEAR);
        int date = calendar.get(Calendar.DATE);
        System.out.println("date = " + date); // date = 21
        System.out.println("year = " + year); // year = 2025
    }
}
