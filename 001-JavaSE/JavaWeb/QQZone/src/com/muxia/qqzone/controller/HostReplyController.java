package com.muxia.qqzone.controller;

import com.muxia.qqzone.pojo.HostReply;
import com.muxia.qqzone.pojo.Reply;
import com.muxia.qqzone.pojo.Topic;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.HostReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class HostReplyController {
    private HostReplyService hostReplyService;
    public String addHostReply(String content,Integer replyId, HttpSession session){
        // 获取 主人信息
        UserBasic author = (UserBasic)session.getAttribute("userBasic");
        // 获取 动态信息
        Topic topic = (Topic) session.getAttribute("topic");
        LocalDateTime now = LocalDateTime.now().withNano(0);
        // 创建 HostReply 实例
        HostReply hostReply = new HostReply(content,now,author,new Reply(replyId));
        // 添加操作
        hostReplyService.addHostReply(hostReply);
        return "redirect:topic.do?oper=getTopicDetail&id="+topic.getId();
    }
}
