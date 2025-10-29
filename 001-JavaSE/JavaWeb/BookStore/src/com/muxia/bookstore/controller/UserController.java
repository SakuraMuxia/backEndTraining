package com.muxia.bookstore.controller;

import com.muxia.bookstore.pojo.User;
import com.muxia.bookstore.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {

    private static final String LOGIN_FAIL_PAGE = "user/login" ;
    private static final String LOGIN_SUCC = "redirect:book.do" ;

    private UserService userService;

    public String login(String uname, String pwd, HttpSession session) {
        User user = userService.getUserByUnameAndPwd(uname, pwd);
        if (user == null) {
            return LOGIN_FAIL_PAGE; //"redirect:page?page=user/login";
        } else {
            session.setAttribute("currUser", user);
            return LOGIN_SUCC;
        }
    }
}
