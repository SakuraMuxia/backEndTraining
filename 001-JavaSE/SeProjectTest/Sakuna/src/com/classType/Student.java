package com.classType;

public class Student {
    private String name;
    private int age;
    private Address address;
    private Hobby[] hobby;
    // set get方法


    public Hobby[] getHobby() {
        return hobby;
    }

    public void setHobby(Hobby[] hobby) {
        this.hobby = hobby;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", hobby=" + hobby +
                '}';
    }
}
