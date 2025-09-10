package com.JDBCTest.BaseDao;

import com.JDBCTest.DBUtil;
import com.JDBCTest.entity.Employee;
import com.JDBCTest.mapper.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BaseDao<T> {
    // 定义一个 增删改的方法,参数是SQL语句和sql中的参数
    public int modifyDataAny(String sql,Object ...args){
        int resRow = 0;
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            // 获取连接对象
            connection = DBUtil.getConnection();
            // 获取pst对象
            pst = connection.prepareStatement(sql);
            // 设置值
            for (int i = 0; i < args.length; i++) {
                // 使用Object类型，解决类型不清楚的问题
                pst.setObject(i+1,args[i]);
            }

            // 执行sql
            resRow = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnect(connection,pst,null);
        }
        // 返回
        return resRow;
    }

    // 定义一个 查询的方法
    public List<T> queryDataAny(String sql, RowMapper<T> rowMapper,Object ...args){
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<T>();
        try {
            connection = DBUtil.getConnection();
            pst = connection.prepareStatement(sql);
            // 设置值
            for (int i = 0; i < args.length; i++) {
                // 使用Object类型，解决类型不清楚的问题
                pst.setObject(i+1,args[i]);
            }
            // 执行sql,得到结果集
            resultSet = pst.executeQuery();

            // 遍历这个结果集
            while(resultSet.next()){
                // 使用数据解析器接口中的方法，把结果集保存到集合中
                T t = rowMapper.parseData(resultSet);
                // 行数据添加到集合中
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnect(connection,pst,resultSet);
        }
        return list;
    }
    // 定义一个查询总数的方法,Count函数的返回
    public int getScalaData(String sql) throws SQLException {
        // 声明数据行
        int res = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;

        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            // 执行
            resultSet = pst.executeQuery();
            // 遍历resultSet
            while (resultSet.next()){
                res = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            DBUtil.closeConnect(con,pst,resultSet);
        }
        // 返回查询到的行数
        return res;
    }
}
