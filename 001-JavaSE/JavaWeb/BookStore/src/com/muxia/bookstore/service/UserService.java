package com.muxia.bookstore.service;

import com.muxia.bookstore.pojo.User;

public interface UserService {
    User getUserByUnameAndPwd(String uname, String pwd);
}
