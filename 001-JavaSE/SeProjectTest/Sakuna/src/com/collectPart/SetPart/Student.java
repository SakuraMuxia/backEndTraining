package com.collectPart.SetPart;

import java.util.Objects;

public class Student implements  Comparable<Student> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    // 重写方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    // 重写比较顺序方法
    @Override
    public int compareTo(Student stu) {
        // return  this.getAge() > stu.getAge() ? 1 :  (this.getAge() < stu.getAge() ? -1  : 0) ;
        return stu.getAge() - this.getAge();
    }
    // 重写equals方法

    // 重写equals和HashCode方法,使用 alt + insert 快捷键添加的,详细见方法重写章节
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
