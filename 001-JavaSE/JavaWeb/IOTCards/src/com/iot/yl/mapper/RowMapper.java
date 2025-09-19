package com.iot.yl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RowMapper <T>{
    // 转化数据方法，ResultSet流中的数据保存到实体类对象中
    T parseData(ResultSet resultSet);

    // 使用 default 修饰，可以直接在接口中实现，他的实现类可以直接调用，不用重写，也可以覆盖重写
    default T parseData(ResultSet resultSet, int rowNum) throws SQLException {
        return parseData(resultSet);
    }

    // 批量解析
    default List<T> parseBatch(ResultSet resultSet) throws SQLException {
        List<T> list = new ArrayList<>();
        Integer rowNum = 0;
        while (resultSet.next()) {
            list.add(parseData(resultSet, ++rowNum));
        }
        return list;
    }
}
