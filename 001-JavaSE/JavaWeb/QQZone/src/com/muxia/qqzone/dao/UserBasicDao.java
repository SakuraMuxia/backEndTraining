package com.muxia.qqzone.dao;

import com.muxia.qqzone.pojo.UserBasic;

public interface UserBasicDao {
    // 登陆
    UserBasic getUserBasicByLoginIdAndPwd(String loginId,String pwd);
}
