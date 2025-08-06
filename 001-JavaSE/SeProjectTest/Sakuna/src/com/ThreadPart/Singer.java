package com.ThreadPart;

public class Singer {
    private String name;
    private int age;
    private int height;

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Singer(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Singer() {
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

}
