package com.enumPart.Test02;

public class Student {
    // 定义 私有属性
    private String sex;
    // 使用 自定义枚举类型
    private Gender gender;

    public static void main(String[] args) {
        // 创建 对象
        Student stu = new Student();
        // 赋值
        stu.sex = "hello";
        // 只能在 Gender 枚举类的 静态常量中 选择
        stu.gender = Gender.MALE;
    }
}
