package com.muxia.qqzone.controller;

import com.muxia.qqzone.pojo.Topic;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.TopicService;
import com.muxia.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

public class TopicController {
    private TopicService topicService;
    private UserBasicService userBasicService;
    // 根据Id获取话题列表
    public String getTopicList(Integer id, HttpSession session){
        //根据id查询对应的 UserBasic
        UserBasic userBasic = userBasicService.getUserBasicById(id);
        // 查询指定用户的topicList
        List<Topic> topicList = topicService.getTopicList(userBasic);
        // for (Topic topic : topicList) {
        //     System.out.println("topic = " + topic);
        // }
        // // 更新main页面中的 session 中的数据 session.userBasic.topicList中的数据
        userBasic.setTopicList(topicList);
        session.setAttribute("mainBasic",userBasic);
        // 转发到 index页面
        // return "index";
        // 转发到 局部主页框架，只更新main区域
        return "frames/main";
        // return null;
    }

    // 根据 topicID 获取详细 动态数据
    public String getTopicDetail(Integer id , HttpSession session){
        // 获取 动态数据对象
        Topic topic = topicService.getTopicWithReplyList(id);
        // 设置到session中
        session.setAttribute("topic",topic);
        // 渲染到 这个页面
        return "frames/detail";
    }

    // 添加新Topic
    public String addTopic(String title,String content,HttpSession session){
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        LocalDateTime now = LocalDateTime.now().withNano(0);
        Topic topic = new Topic(title, content, now, author);
        topicService.addTopic(topic);
        return "redirect:topic.do?oper=getTopicList&id=" + author.getId();
    }
    // 删除Topic
    public String delTopic(Integer id,HttpSession session){
        topicService.delTopic(id);
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        return "redirect:topic.do?oper=getTopicList&id=" + author.getId();
    }
}
