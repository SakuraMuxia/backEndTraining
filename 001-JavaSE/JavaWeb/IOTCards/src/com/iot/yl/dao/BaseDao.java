package com.iot.yl.dao;

import com.iot.yl.mapper.RowMapper;
import com.iot.yl.utils.DBType;
import com.iot.yl.utils.DButil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 定义BaseDao为一个抽象类
public abstract class BaseDao<T> {

    private Class<T> clazz;

    // 构造方法，子类传入实体类类型
    public BaseDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    // 定义ResultSet结果集
    private ResultSet rs;
    // 连接池对象
    Connection connection = null;
    // sql语句对象
    PreparedStatement pstm = null;

    // 定义设置参数的方法
    private void setParams(PreparedStatement psmt , Object... params) throws SQLException {
        if(params!=null && params.length>0){
            for (int i = 0; i < params.length; i++) {
                psmt.setObject(i+1,params[i]);
            }
        }
    }

    // 查询列表的方法
    protected List<T> executeQuery(DBType dbType,String sql,RowMapper<T> rowMapper,Object ...params){
        List<T> list = new ArrayList<>();
        try {
            connection = DButil.getConnection(dbType);
            // 获取statement对象
            pstm = connection.prepareStatement(sql);
            // 设置SQL参数
            setParams(pstm,params);
            // 执行SQL
            rs = pstm.executeQuery();
            // 方式1：通过反射来处理
            // 方式2：通过数据解析器来处理（见JDBC章节）
            // 获取结果集的元数据，也就是每一行的数据
            ResultSetMetaData metaData = rs.getMetaData();
            // 获取元数据的列数
            int columnCount = metaData.getColumnCount();
            // 遍历结果集
            while(rs.next()){
                // 方式1：使用反射
                // T obj = clazz.getDeclaredConstructor().newInstance();
                // try {
                //     // 反射设置字段
                //     Field field = clazz.getDeclaredField(colName);
                //     field.setAccessible(true);
                //     field.set(obj, value);
                // } catch (NoSuchFieldException e) {
                //     // 忽略实体类没有的列
                // }

                // 方式2：使用数据解析器,添加对象
                T t = rowMapper.parseData(rs);
                // 集合中添加元素
                // list.add(obj);
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,pstm,rs);
        }
        return list;
    }
    // ---------------- 可选：返回单条记录 ----------------
    public T executeQuerySingle(DBType dbType, String sql,RowMapper<T> rowMapper,Object... params) {
        List<T> list = executeQuery(dbType, sql,rowMapper,params);
        return list.isEmpty() ? null : list.get(0);
    }

    // 获取数量总数的
    public Integer executeQueryNum(DBType dbType,String sql,Object... params){
        Integer count = 0;
        try {
            // 建立连接
            connection = DButil.getConnection(dbType);
            // 获取statement对象
            pstm = connection.prepareStatement(sql);
            // 设置SQL参数
            setParams(pstm,params);
            // 执行SQL
            rs = pstm.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1); // 获取第一列的数量
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.close(connection,pstm,rs);
        }
        return count;
    }
}
