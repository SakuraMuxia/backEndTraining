package com.DatePart;

import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        // 无参构造
        Date date = new Date(); 
        System.out.println("date = " + date); // 默认调用了Date类中重写的toString方法

        // 有参构造1
        // 传入的年份 + 1900 = 真正的年份
        // 传入的月份 + 1 = 真正月份
        Date date1 = new Date(125,6,21); 
        System.out.println("date1 = " + date1);

        // 有参构造2 System.currentTimeMillis() 当前系统时间毫秒数
        Date date2 = new Date(System.currentTimeMillis());
        System.out.println("date2 = " + date2);

        int month = date1.getMonth();
        System.out.println("time = " + month);


    }
}
