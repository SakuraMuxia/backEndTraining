package com.JDBCTest;

import java.sql.*;

/*
    数据库工具
    1. 获取连接对象
 */
public class DBUtil {
    // 定义一个静态方法,返回值为 Connection对象 （sql包中的）
    public static Connection getConnection(){
        // 定义一个 connection对象
        Connection connection = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接对象
            String url = "jdbc:mysql://192.168.1.38:3306/chatai";
            String userName = "hanser";
            String password = "123.com";
            // 获取对象
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnect(Connection con, PreparedStatement pst, ResultSet res){
        // 判断是否为空,关闭读取流
        try {
            if (res != null){
                res.close();
            }
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
