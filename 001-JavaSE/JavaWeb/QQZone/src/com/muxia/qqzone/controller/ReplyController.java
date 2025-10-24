package com.muxia.qqzone.controller;

import com.muxia.qqzone.pojo.Reply;
import com.muxia.qqzone.pojo.Topic;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReplyController {
    private ReplyService replyService;
    // 这里是 客人 向 动态添加 评论
    public String addReply(Integer topicId, String content, HttpSession session){
        // 获取评论者主人信息
        UserBasic author = (UserBasic)session.getAttribute("userBasic");
        LocalDateTime now = LocalDateTime.now().withNano(0);
        // String mysqlTime = createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // 创建 reply 实例
        Reply reply = new Reply(content,now,author,new Topic(topicId));
        // 执行添加 操作
        replyService.addReply(reply);

        // 转发页面
        return "redirect:topic.do?oper=getTopicDetail&id="+topicId;
    }
    public String delReply(Integer replyId,HttpSession session){
        replyService.delReply(replyId);
        Topic topic = (Topic) session.getAttribute("topic");
        return "redirect:topic.do?oper=getTopicDetail&id="+topic.getId();
    }
}
