package com.DatePart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println("date = " + date);

        // 使用SimpleDateFormat类中的方法转换Date对象
        SimpleDateFormat sdf = new SimpleDateFormat(); // 使用无参构造,以默认格式转化以及解析日期
        String dateStr = sdf.format(date); // 将Date对象转String
        Date date1 = sdf.parse("25-7-21 下午4:15"); // 将String对象转Date对象
        System.out.println("dateStr = " + dateStr); // dateStr = 25-7-21 下午4:12
        System.out.println("date1 = " + date1); // Mon Jul 21 16:15:00 CST 2025

        // 模版1 yyyy-MM-dd HH:mm:ss
        // 模版2 yyyy年MM月dd日 HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"); // 使用有参构造
        String dateStr1 = sdf1.format(date);
        System.out.println("dateStr1 = " + dateStr1); // dateStr1 = 2025年07月21日 16:18:44



    }
}
