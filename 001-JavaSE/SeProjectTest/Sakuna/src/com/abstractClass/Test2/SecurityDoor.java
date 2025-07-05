package com.abstractClass.Test2;

public class SecurityDoor extends Door{
    private String password;

    public SecurityDoor(String password) {
        this.password = password;
    }

    public SecurityDoor() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void open() {
        System.out.println("防盗门开门，输入密码，按下指纹，门自动打开");
    }

    @Override
    public void close() {
        System.out.println("防盗门关门，障碍物识别，自动关门");
    }
}
