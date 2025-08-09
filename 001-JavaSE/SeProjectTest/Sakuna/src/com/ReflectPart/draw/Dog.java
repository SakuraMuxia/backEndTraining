package com.ReflectPart.draw;

public class Dog extends Pet{
    private String strain;
    public Dog() {}

    public Dog(String name, String strain) {
        super(name);
        this.strain = strain;
    }
}
