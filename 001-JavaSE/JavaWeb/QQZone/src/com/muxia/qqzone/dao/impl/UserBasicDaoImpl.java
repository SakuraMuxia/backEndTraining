package com.muxia.qqzone.dao.impl;

import com.muxia.qqzone.dao.UserBasicDao;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.myssm.dao.BaseDao;

public class UserBasicDaoImpl extends BaseDao<UserBasic> implements UserBasicDao {
    @Override
    public UserBasic getUserBasicByLoginIdAndPwd(String loginId, String pwd) {
        return load("select * from t_user_basic where loginId = ? and pwd = ? ",loginId,pwd);
    }
}
