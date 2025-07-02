package com.classType;

public class Hobby {
    private String hobbyType;
    private String hobbyName;

    public String getHobbyType() {
        return hobbyType;
    }

    public void setHobbyType(String hobbyType) {
        this.hobbyType = hobbyType;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    // 重写toString

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyType='" + hobbyType + '\'' +
                ", hobbyName='" + hobbyName + '\'' +
                '}';
    }
}
