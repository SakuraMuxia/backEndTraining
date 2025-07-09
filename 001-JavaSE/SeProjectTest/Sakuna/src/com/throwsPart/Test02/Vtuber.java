package com.throwsPart.Test02;

public class Vtuber {
    private String name;
    private int age;
    private char sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    // 使用 Throw 抛出异常
    public void setAge(int age){
        if(age > 0 && age < 130){
            this.age = age;
        }else{
            throw new InputAgeNumOutOfboundsException("年龄不合法" + age);
        }

    }

    public char getSex() {
        return sex;
    }
    // 使用 throws 声明异常
    public void setSex(char sex) throws InputSexException{
        if(sex == '男' || sex == '女'){
            this.sex = sex;
        }else{
            throw new InputSexException("性别不合法" + sex);
        }
    }

    public Vtuber(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Vtuber() {
    }

    @Override
    public String toString() {
        return "Vtuber{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
