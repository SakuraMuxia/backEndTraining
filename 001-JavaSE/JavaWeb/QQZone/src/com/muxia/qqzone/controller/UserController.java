package com.muxia.qqzone.controller;

import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;

public class UserController {
    private static final String PAGE_INDEX = "index";
    private static final String LOGIN_SUCC = "redirect:user.do";
    private static final String LOGIN_FAIL = "redirect:page?page=login";

    // 声明 用户 service
    private UserBasicService userBasicService ;

    public String login(String loginId, String pwd, HttpSession session){
        UserBasic userBasic = userBasicService.login(loginId,pwd);
        if (userBasic != null){
            // userBasic这个key用来代表登陆者
            session.setAttribute("userBasic",userBasic);
            return LOGIN_SUCC;
        }else{
            System.out.println("登陆失败"+userBasic);
            return LOGIN_FAIL;

        }
    }
}
