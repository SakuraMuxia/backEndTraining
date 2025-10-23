package com.muxia.qqzone.controller;

import com.muxia.qqzone.pojo.Topic;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.TopicService;
import com.muxia.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {
    private static final String PAGE_INDEX = "index";
    private static final String LOGIN_SUCC = "redirect:user.do";
    private static final String LOGIN_FAIL = "redirect:page?page=login";

    // 声明 用户 service
    private UserBasicService userBasicService ;
    private TopicService topicService;

    public String login(String loginId, String pwd, HttpSession session){
        UserBasic userBasic = userBasicService.login(loginId,pwd);
        if (userBasic != null){
            // userBasic这个key用来代表登陆者
            session.setAttribute("userBasic",userBasic);
            // friend 这个key代表当前空间是谁
            session.setAttribute("mainBasic",userBasic);
            return LOGIN_SUCC;
        }else{
            System.out.println("登陆失败"+userBasic);
            return LOGIN_FAIL;

        }
    }

    public String list(HttpSession session){
        // 从session中取出当前登陆者信息
        UserBasic userBasic =(UserBasic) session.getAttribute("userBasic");
        // 加载好友列表
        List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
        // 加载日志列表
        List<Topic> topicList = topicService.getTopicList(userBasic);

        // 在设置属性时 注意 pojo定义的类型和 数据库中的类型不一样，需要进行一下转换

        // 设置 属性到 userBasic 对象中
        userBasic.setFriendList(friendList);
        userBasic.setTopicList(topicList);

        // 返回到首页
        return PAGE_INDEX;
    }
}
