package com.methodRenamePart;

public class Vtuber {
    String name;
    int age;
    char gender;
    String height;

    public Vtuber() {
    }

    public Vtuber(String name, int age, char gender, String height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Vtuber{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", height='" + height + '\'' +
                '}';
    }
}
