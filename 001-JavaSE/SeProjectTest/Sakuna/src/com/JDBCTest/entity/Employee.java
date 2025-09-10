package com.JDBCTest.entity;

import java.util.Date;

/**
 * ORM Object Relation Mapping 对象关系映射
 * 将数据库中的表结构和Java代码中的实体类一一对应
 */
public class Employee {
    // 使用包装类，默认值为null，不会造成数据混乱
    private Integer empId;
    private String empName;
    private Integer empAge;
    private String empAddress;
    private String empSex;
    private Date empBirthday;
    private Double empScore;
    private Integer depId;
    private String empInfo;
    private Integer empStatus;

    // 封装

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public Double getEmpScore() {
        return empScore;
    }

    public void setEmpScore(Double empScore) {
        this.empScore = empScore;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getEmpInfo() {
        return empInfo;
    }

    public void setEmpInfo(String empInfo) {
        this.empInfo = empInfo;
    }

    public Integer getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(Integer empStatus) {
        this.empStatus = empStatus;
    }
    // 构造

    public Employee(Integer empId, String empName, Integer empAge, String empAddress, String empSex, Date empBirthday, Double empScore, Integer depId, String empInfo, Integer empStatus) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empAddress = empAddress;
        this.empSex = empSex;
        this.empBirthday = empBirthday;
        this.empScore = empScore;
        this.depId = depId;
        this.empInfo = empInfo;
        this.empStatus = empStatus;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empAddress='" + empAddress + '\'' +
                ", empSex='" + empSex + '\'' +
                ", empBirthday=" + empBirthday +
                ", empScore=" + empScore +
                ", depId=" + depId +
                ", empInfo='" + empInfo + '\'' +
                ", empStatus=" + empStatus +
                '}';
    }
}
