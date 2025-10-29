package com.muxia.bookstore.dao;

import com.muxia.bookstore.pojo.User;

public interface UserDao {
    User getUserByUnameAndPwd(String uname,String pwd);
}
