package com.insideClassPart;

public class Student {
    public String name;
    public int age;
    public Address address;

    // 内部类Address类,属于某个实例级别的,作为实例的属性来使用
    public class Address{ // 同时通常将内部类私有
        private String city;
        private String country;
        private String zone;

    }
}
