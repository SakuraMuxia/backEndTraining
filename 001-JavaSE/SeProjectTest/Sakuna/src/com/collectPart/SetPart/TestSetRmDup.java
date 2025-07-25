package com.collectPart.SetPart;

import java.util.HashSet;

public class TestSetRmDup {
    public static void main(String[] args) {
        // 创建HashSet接口
        HashSet<Student> hashSet = new HashSet<Student>();
        // 创建对象
        Student stu1 = new Student("九月",16);
        Student stu2 = new Student("九月",16);
        Student stu3 = new Student("九月",16);
        // 添加三个元素，这三个元素是重复的，在未重写 equals 方法之前，这三个都可以添加进去

        // 使用equals比较是否为true,如果Student类重写equals则使用Student重写后的;如果没有重写，则用父类（默认比较对象地址）
        boolean stu12 = stu1.equals(stu2);
        boolean stu13 = stu1.equals(stu3);
        System.out.println("stu12 = " + stu12); // 未重写前 false; 重写后 true
        System.out.println("stu13 = " + stu13); // 未重写前 false; 重写后 true

        // 打印hash值,调用hashCode方法,如果Student类重写hashCode方法则使用本类重写的方法; 如果没有重写则用父类;
        int stu1Code = stu1.hashCode();
        int stu2Code = stu2.hashCode();
        int stu3Code = stu3.hashCode();
        System.out.println("stu1Code = " + stu1Code); // 未重写前 1163157884; 重写后 相同 20097254
        System.out.println("stu2Code = " + stu2Code); // 未重写前 1956725890; 重写后 相同 20097254
        System.out.println("stu3Code = " + stu3Code); // 未重写前 356573597; 重写后 相同 20097254

        // 未重写 equals和hashCode方法，会被认为是不同的对象，可以被添加到列表中

        hashSet.add(stu1);
        hashSet.add(stu2);
        hashSet.add(stu3);

        // 遍历
        for (Student student : hashSet) {
            System.out.println(student); // 未重写前列表汇中有三个;重写后只有一个;
        }
    }
}
