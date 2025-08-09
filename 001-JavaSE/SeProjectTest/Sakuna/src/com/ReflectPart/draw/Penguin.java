package com.ReflectPart.draw;

public class Penguin extends Pet{
    private char gender;

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Penguin() {}

    public Penguin(String name, char gender) {
        super(name);
        this.gender = gender;
    }
}
