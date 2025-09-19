package com.iot.yl.pojo;

public class CoolerCard {
    // 定义属性
    private String sn;
    private String full_sn;
    private String sn_name;

    public CoolerCard(String sn, String full_sn, String sn_name) {
        this.sn = sn;
        this.full_sn = full_sn;
        this.sn_name = sn_name;
    }

    public String getFull_sn() {
        return full_sn;
    }

    public void setFull_sn(String full_sn) {
        this.full_sn = full_sn;
    }

    public CoolerCard() {
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSn_name() {
        return sn_name;
    }

    public void setSn_name(String sn_name) {
        this.sn_name = sn_name;
    }

    @Override
    public String toString() {
        return "CoolerCard{" +
                "sn='" + sn + '\'' +
                ", full_sn='" + full_sn + '\'' +
                ", sn_name='" + sn_name + '\'' +
                '}';
    }
}
