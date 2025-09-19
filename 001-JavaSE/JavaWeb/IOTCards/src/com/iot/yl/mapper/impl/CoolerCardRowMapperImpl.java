package com.iot.yl.mapper.impl;

import com.iot.yl.mapper.RowMapper;
import com.iot.yl.pojo.CoolerCard;

import java.sql.ResultSet;

public class CoolerCardRowMapperImpl implements RowMapper<CoolerCard> {

    @Override
    public CoolerCard parseData(ResultSet resultSet) {
        // 创建实体类
        CoolerCard coolerCard = new CoolerCard();
        try {
            // 存储每一行的数据到 实体类中
            coolerCard.setSn(resultSet.getString(1));
            coolerCard.setSn_name(resultSet.getString(2));
            coolerCard.setFull_sn("8986"+resultSet.getString(1));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return coolerCard;
    }
}
