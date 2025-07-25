package com.collectPart.TreeMapPart;

public class Singer {
    private String name;
    private int age;

    // 封装
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

    public Singer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 重写
    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
