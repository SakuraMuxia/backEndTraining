package com.generic;

public class Vup {
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

    public Vup(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Vup() {
    }

    @Override
    public String toString() {
        return "Vup{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
