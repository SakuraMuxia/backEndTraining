package com.iot.yl.dao.impl;

import com.iot.yl.dao.BaseDao;
import com.iot.yl.dao.CoolerDao;
import com.iot.yl.mapper.RowMapper;
import com.iot.yl.mapper.impl.CoolerCardRowMapperImpl;
import com.iot.yl.pojo.CoolerCard;
import com.iot.yl.utils.DBType;

import java.util.List;

public class CoolerDaoImpl extends BaseDao<CoolerCard> implements CoolerDao {

    public CoolerDaoImpl() {
        super(CoolerCard.class);
    }

    @Override
    public List<CoolerCard> getCoolTeleCards() {
        RowMapper rowMapper = new CoolerCardRowMapperImpl();
        String sql = "select sn,sn_name from device_info where sn like '1122%' AND is_deleted = 0 order by sn desc";
        List<CoolerCard> cards = executeQuery(DBType.DB1,sql,rowMapper,null);
        return cards;
    }

    @Override
    public Integer getCoolTeleCardNum() {
        String sql = "select COUNT(*) from device_info where sn like '1122%' AND is_deleted = 0";
        Integer nums = executeQueryNum(DBType.DB1, sql, null);
        return nums;
    }

    @Override
    public List<CoolerCard> getCoolUniCards() {
        RowMapper rowMapper = new CoolerCardRowMapperImpl();
        String sql = "select sn,sn_name from device_info where sn like '06%' AND is_deleted = 0 order by sn desc";
        List<CoolerCard> cards = executeQuery(DBType.DB1,sql,rowMapper,null);
        return cards;
    }

    @Override
    public Integer getCoolUniCardNum() {
        String sql = "select COUNT(*) from device_info where sn like '06%' AND is_deleted = 0";
        Integer nums = executeQueryNum(DBType.DB1, sql, null);
        return nums;
    }

    @Override
    public List<CoolerCard> getCoolMobCards() {
        RowMapper rowMapper = new CoolerCardRowMapperImpl();
        String sql = "select sn,sn_name from device_info where sn like '04%' AND is_deleted = 0 order by sn desc";
        List<CoolerCard> cards = executeQuery(DBType.DB1,sql,rowMapper,null);
        return cards;
    }

    @Override
    public Integer getCoolMobCardNum() {
        String sql = "select COUNT(*) from device_info where sn like '04%' AND is_deleted = 0";
        Integer nums = executeQueryNum(DBType.DB1, sql, null);
        return nums;
    }
}
