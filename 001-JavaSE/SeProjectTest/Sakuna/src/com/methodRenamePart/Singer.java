package com.methodRenamePart;

public class Singer extends Vtuber{
    String sings;

    public Singer(String sings) {
        this.sings = sings;
    }

    public Singer(String name, int age, char gender, String height, String sings) {
        super(name, age, gender, height);
        this.sings = sings;
    }

    public String getSings() {
        return sings;
    }

    public void setSings(String sings) {
        this.sings = sings;
    }
}
