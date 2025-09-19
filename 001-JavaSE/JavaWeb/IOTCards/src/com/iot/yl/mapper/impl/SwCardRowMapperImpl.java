package com.iot.yl.mapper.impl;

import com.iot.yl.mapper.RowMapper;
import com.iot.yl.pojo.SwCard;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SwCardRowMapperImpl implements RowMapper<SwCard> {
    @Override
    public SwCard parseData(ResultSet resultSet) {
        // 创建实体类
        SwCard swCard = new SwCard();
        try {
            swCard.setSn(resultSet.getString(1));
            swCard.setLocation(resultSet.getString(2));
            swCard.setFull_sn("8986"+resultSet.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return swCard;
    }
}
