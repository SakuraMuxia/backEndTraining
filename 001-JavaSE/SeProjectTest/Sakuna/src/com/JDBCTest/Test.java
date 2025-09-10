package com.JDBCTest;

import java.sql.*;

public class Test {
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
            // 3. 创建执行SQL语句st对象
            Statement st = connection.createStatement();
            // 4. 编写SQL
            String sql = "select * from department";
            // 5. 执行SQL
            ResultSet resultSet = st.executeQuery(sql);
            // 6. 遍历结果集
            while (resultSet.next()){
                int anInt = resultSet.getInt(1);
                String anString = resultSet.getString(2);
                System.out.println("第一列数据为:" + anInt);
                System.out.println("第二列数据为:" + anString);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
