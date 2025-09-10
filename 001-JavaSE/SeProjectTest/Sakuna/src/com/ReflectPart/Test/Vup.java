package com.ReflectPart.Test;

public class Vup {
    public String name;
    int age;
    private int height;

    public Vup() {

    }
    private Vup(String name) {
        this.name = name;
    }
    public Vup(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Vup{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}