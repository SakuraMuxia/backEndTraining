package com.muxia.qqzone.dao.impl;

import com.muxia.qqzone.dao.UserBasicDao;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.myssm.dao.BaseDao;

import java.util.List;

public class UserBasicDaoImpl extends BaseDao<UserBasic> implements UserBasicDao {
    @Override
    public UserBasic getUserBasicByLoginIdAndPwd(String loginId, String pwd) {
        return load("select * from t_user_basic where loginId = ? and pwd = ? ;",loginId,pwd);
    }

    @Override
    public List<UserBasic> getUserFriendList(UserBasic userBasic) {
        Integer id = userBasic.getId();
        String sql = "select t3.* from t_user_basic t1\n" +
                "    left join t_friend t2 on t1.id = t2.uid\n" +
                "    inner join t_user_basic t3 on t2.fid = t3.id\n" +
                "    where t1.id = ?\n" +
                ";";
        return executeQuery(sql,id);
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        String sql = "select * from t_user_basic where id = ?;";
        return load(sql,id);
    }
}
