package com.muxia.qqzone.service.impl;

import com.muxia.qqzone.dao.UserBasicDao;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.UserBasicService;

import java.util.List;

public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDao userBasicDao;

    @Override
    public UserBasic login(String loginId, String pwd) {
        return userBasicDao.getUserBasicByLoginIdAndPwd(loginId,pwd);
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return userBasicDao.getUserBasicById(id);
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        return userBasicDao.getUserFriendList(userBasic);
    }
}
