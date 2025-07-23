package com.StringBufferPart;

public class Demo1 {
    public static void main(String[] args) {
        // 定义一个 StringBuffer类 对象
        StringBuffer str1 = new StringBuffer();
        // 追加char类型
        str1.append('a');
        // 追加String类型
        str1.append("hello");
        // 追加int类型
        str1.append(123);
        // 追加float类型
        str1.append(3.6F);
        // 追加布尔类型
        str1.append(true);
        // 打印输出
        System.out.println("str1: " + str1);

        StringBuffer str2 = str1.delete(0, 2);
        System.out.println("str2: " + str2);

        StringBuffer str3 = str2.deleteCharAt(0);
        System.out.println("str3 = " + str3);

        StringBuffer aqua = str3.insert(0, "aqua");
        System.out.println("aqua = " + aqua);

        StringBuffer kawaii = aqua.replace(5, 10, "kawaii");
        System.out.println("kawaii = " + kawaii);
        StringBuffer str4 = kawaii.reverse();
        System.out.println("str4 = " + str4);

        str4.setCharAt(1,'H');
        System.out.println("str4 = " + str4);
    }
}
