package com.muxia.qqzone.service;

import com.muxia.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicService {
    // 登陆方法
    UserBasic login(String loginId,String pwd);
    // 获取用户基本信息
    UserBasic getUserBasicById(Integer id);
    // 获取好友列表方法
    List<UserBasic> getFriendList(UserBasic userBasic);

}
