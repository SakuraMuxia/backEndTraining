package com.JDBCTest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class pstCURD {
    // 使用preparedStatement增加数据
    @Test
    public void addData(){
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            // 调用封装的工具类,获取连接对象
            connection = DBUtil.getConnection();
            // 定义sql
            String sql = "insert into employee values (?,?,?,?,?,?,?,?,?,?)";
            // 创建pst对象
            pst = connection.prepareStatement(sql);
            // 创建一个日期对象
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowDate = sdf.format(date);
            // 设置值
            pst.setInt(1,16);
            pst.setString(2,"sakuna");
            pst.setInt(3,21);
            pst.setString(4,"日本东京");
            pst.setString(5,"女");
            // 这里使用 java.sql中的Date类的构造方法，参数是一个毫秒数
            pst.setDate(6,new java.sql.Date(System.currentTimeMillis()));
            pst.setDouble(7,98.98);
            pst.setInt(8,2);
            pst.setString(9,"歌姬");
            pst.setInt(10,1);
            // 执行SQL
            int resRow = pst.executeUpdate();
            System.out.println("resRow = " + resRow);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnect(connection,pst,null);
        }
    }

    @Test
    public void editData(){
        Connection connection = null;
        PreparedStatement pst = null;

        try {
            // 调用封装的工具类,获取连接对象
            connection = DBUtil.getConnection();
            // 定义sql
            String sql = "update employee set empname = ? where empid = ?";
            // 创建pst对象
            pst = connection.prepareStatement(sql);
            // 设置值
            pst.setString(1,"Akie");
            pst.setInt(2,14);
            // 执行SQL
            int resRow = pst.executeUpdate();
            System.out.println("resRow = " + resRow);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnect(connection,pst,null);
        }
    }
}
