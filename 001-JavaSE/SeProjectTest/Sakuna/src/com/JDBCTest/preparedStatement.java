package com.JDBCTest;

import java.sql.*;

public class preparedStatement {
    public static void main(String[] args) {
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接对象
            String url = "jdbc:mysql://192.168.1.38:3306/chatai";
            String userName = "hanser";
            String password = "123.com";
            // 获取对象
            Connection connection = DriverManager.getConnection(url, userName, password);
            // 定义SQL
            String sql = "select * from employee where empname = ?";

            // 创建preparedStatement对象
            PreparedStatement pst = connection.prepareStatement(sql);
            // 赋值,第一个?处，设置值
            pst.setString(1,"aqua");
            // 执行SQL
            ResultSet resultSet = pst.executeQuery();
            // 遍历结果集
            while (resultSet.next()){
                int empId = resultSet.getInt(1);
                String empName = resultSet.getString(2);
                String empAddress = resultSet.getString(4);
                // 打印信息
                System.out.println("id为："+empId+"，名字为："+empName+"，地址为："+empAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源

        }
    }
}
