package com.iot.yl.dao;

import com.iot.yl.pojo.CoolerCard;

import java.util.List;

public interface CoolerDao{
    // 获取电信卡列表
    List<CoolerCard> getCoolTeleCards();
    // 获取电信卡数量
    Integer getCoolTeleCardNum();
    // 获取联通卡
    List<CoolerCard> getCoolUniCards();
    Integer getCoolUniCardNum();
    // 获取移动卡
    List<CoolerCard> getCoolMobCards();
    Integer getCoolMobCardNum();
}
