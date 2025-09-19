package com.iot.yl.dao.impl;

import com.iot.yl.dao.BaseDao;
import com.iot.yl.dao.SwDao;
import com.iot.yl.mapper.RowMapper;
import com.iot.yl.mapper.impl.SwCardRowMapperImpl;
import com.iot.yl.pojo.SwCard;
import com.iot.yl.utils.DBType;

import java.util.List;

public class SwDaoImpl extends BaseDao<SwCard> implements SwDao {

    public SwDaoImpl() {
        super(SwCard.class);
    }

    @Override
    public List<SwCard> getSwTelCards() {
        RowMapper rowMapper = new SwCardRowMapperImpl();
        String sql = "select sn,location from DEV_CFG where sn like '1122%' AND is_deleted = 1 order by sn desc";
        List<SwCard> list = executeQuery(DBType.DB2, sql, rowMapper, null);
        return list;
    }

    @Override
    public Integer getSwTelCardNum() {
        RowMapper rowMapper = new SwCardRowMapperImpl();
        String sql = "select COUNT(*) from DEV_CFG where sn like '1122%' AND is_deleted = 1";
        Integer nums = executeQueryNum(DBType.DB2, sql, null);
        return nums;
    }

    @Override
    public List<SwCard> getSwUniCards() {
        RowMapper rowMapper = new SwCardRowMapperImpl();
        String sql = "select sn,location from DEV_CFG where sn like '06%' AND is_deleted = 1 order by sn desc";
        List<SwCard> list = executeQuery(DBType.DB2, sql, rowMapper, null);
        return list;
    }

    @Override
    public Integer getSwUniCardNum() {
        RowMapper rowMapper = new SwCardRowMapperImpl();
        String sql = "select COUNT(*) from DEV_CFG where sn like '06%' AND is_deleted = 1";
        Integer nums = executeQueryNum(DBType.DB2, sql, null);
        return nums;
    }

    @Override
    public List<SwCard> getSwMobCards() {
        RowMapper rowMapper = new SwCardRowMapperImpl();
        String sql = "select sn,location from DEV_CFG where sn like '04%' AND is_deleted = 1 order by sn desc";
        List<SwCard> list = executeQuery(DBType.DB2, sql, rowMapper, null);
        return list;
    }

    @Override
    public Integer getSwMobCardNum() {
        RowMapper rowMapper = new SwCardRowMapperImpl();
        String sql = "select COUNT(*) from DEV_CFG where sn like '04%' AND is_deleted = 1";
        Integer nums = executeQueryNum(DBType.DB2, sql, null);
        return nums;
    }
}
