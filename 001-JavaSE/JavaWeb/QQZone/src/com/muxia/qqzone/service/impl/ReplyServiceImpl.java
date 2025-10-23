package com.muxia.qqzone.service.impl;

import com.muxia.qqzone.dao.ReplyDao;
import com.muxia.qqzone.dao.UserBasicDao;
import com.muxia.qqzone.pojo.HostReply;
import com.muxia.qqzone.pojo.Reply;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.HostReplyService;
import com.muxia.qqzone.service.ReplyService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDao replyDao;
    private UserBasicDao userBasicDao;
    private HostReplyService hostReplyService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        // 获取replyList日志列表
        List<Reply> replyList = replyDao.getReplyListByTopicId(topicId);
        // 遍历回复日志列表
        for (Reply reply : replyList) {
            // 获取作者id
            Integer authorId = reply.getAuthor().getId();
            Integer replyId = reply.getId();
            // 获取主人回复数据
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(replyId);
            // 获取作者的信息
            UserBasic author = userBasicDao.getUserBasicById(authorId);
            // 设置作者信息到 Reply中
            reply.setAuthor(author);
            reply.setHostReply(hostReply);
        }
        return replyList;
    }
}
