package com.JDBCTest.statementPart;

import java.sql.*;
import java.text.SimpleDateFormat;

public class JDBCQuery {
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
            // 定义变量
            String name = "aqua";
            int age = 18;
            String address = "河南郑州";
            char sex = '女';
            Date birthday = new Date(System.currentTimeMillis());
            // Date对象转为字符串
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateBirthday = sdf.format(birthday);
            double score = 98.98;
            int depid = 2;

            // 4. 编写SQL，通过字符串拼接的方式
            // "+ age +" 这里表示把一个变量 转成一个字符串
            // 这里需要给 String类型的外边再添加一个 '' 因为这是sql中的语法
            String sql = "SELECT * FROM employee where ename='" + name + "'";
            // 5. 执行SQL
            int result = st.executeUpdate(sql);
            System.out.println("result = " + result);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
