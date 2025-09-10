package com.ReflectPart.AnnoAndReflect.DataBaseDemo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class DataInfo {
    // 定义属性
    @UserName("root")
    private String userName;

    @Password("****")
    @Driver("123")
    private String password;

    @URL(url = "jdbc:mysql://localhost:3306/dbName")
    private String URL;

    @Driver("com.mysql.cj.jdbc.Driver")
    private String driver;

    public DataInfo(String userName, String password, String URL, String driver) {
        this.userName = userName;
        this.password = password;
        this.URL = URL;
        this.driver = driver;
    }
}
