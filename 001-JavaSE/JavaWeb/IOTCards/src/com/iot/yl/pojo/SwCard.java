package com.iot.yl.pojo;

public class SwCard {
    // 定义属性
    private String sn;
    private String full_sn;
    private String location;

    public SwCard(String sn, String full_sn, String location) {
        this.sn = sn;
        this.full_sn = full_sn;
        this.location = location;
    }

    public SwCard() {
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getFull_sn() {
        return full_sn;
    }

    public void setFull_sn(String full_sn) {
        this.full_sn = full_sn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SwCard{" +
                "sn='" + sn + '\'' +
                ", full_sn='" + full_sn + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
