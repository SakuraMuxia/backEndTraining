package com.muxia.qqzone.service.impl;

import com.muxia.qqzone.dao.UserBasicDao;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.UserBasicService;

public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDao userBasicDao;

    @Override
    public UserBasic login(String loginId, String pwd) {
        return userBasicDao.getUserBasicByLoginIdAndPwd(loginId,pwd);
    }
}
