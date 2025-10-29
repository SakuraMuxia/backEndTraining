package com.muxia.bookstore.dao.impl;

import com.muxia.bookstore.dao.UserDao;
import com.muxia.bookstore.myssm.dao.BaseDao;
import com.muxia.bookstore.pojo.User;

public class UserDaoImpl extends BaseDao<User> implements  UserDao {
    @Override
    public User getUserByUnameAndPwd(String uname, String pwd) {
        String sql = "select * from t_user where uname = ? and pwd = ?";
        return load(sql,uname,pwd);
    }
}
