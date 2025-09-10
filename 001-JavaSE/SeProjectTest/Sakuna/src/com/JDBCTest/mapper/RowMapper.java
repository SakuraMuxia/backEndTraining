package com.JDBCTest.mapper;
import java.sql.ResultSet;

/**
 * 解析器接口：
 * 用来根据结果集解析不同的数据，因为数据不同，所以类型是不确定，所以使用泛型
 * @param <T>
 */
public interface RowMapper<T> {
    // 转化数据方法，ResultSet流中的数据保存到实体类对象中
    T parseData(ResultSet resultSet);
}
