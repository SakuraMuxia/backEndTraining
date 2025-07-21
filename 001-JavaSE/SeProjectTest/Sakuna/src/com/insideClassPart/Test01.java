package com.insideClassPart;

public class Test01 {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "aqua";
        stu.age = 18;
        // 当内部类的修饰符为 public时
        stu.address = stu.new Address();
        // 临时new一个Student对象
        Student.Address address = new Student().new Address();
    }
}
