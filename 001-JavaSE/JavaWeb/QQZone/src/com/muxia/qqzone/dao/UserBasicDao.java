package com.muxia.qqzone.dao;

import com.muxia.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicDao {
    // 登陆
    UserBasic getUserBasicByLoginIdAndPwd(String loginId,String pwd);
    // 获取用户的好友列表
    List<UserBasic> getUserFriendList(UserBasic userBasic);
    // 获取用户信息
    UserBasic getUserBasicById(Integer id);
}
