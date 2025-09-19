package com.iot.yl.dao;


import com.iot.yl.pojo.SwCard;

import java.util.List;

public interface SwDao {
    // 获取电信卡列表
    List<SwCard> getSwTelCards();
    Integer getSwTelCardNum();
    // 获取联通卡
    List<SwCard> getSwUniCards();
    Integer getSwUniCardNum();
    // 获取移动卡
    List<SwCard> getSwMobCards();
    Integer getSwMobCardNum();
}
