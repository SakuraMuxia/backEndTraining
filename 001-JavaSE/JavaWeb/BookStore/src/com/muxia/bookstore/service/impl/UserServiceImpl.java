package com.muxia.bookstore.service.impl;

import com.muxia.bookstore.dao.UserDao;
import com.muxia.bookstore.pojo.User;
import com.muxia.bookstore.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public User getUserByUnameAndPwd(String uname, String pwd) {
        return userDao.getUserByUnameAndPwd(uname,pwd);
    }
}
