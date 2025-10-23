package com.muxia.qqzone.service;

import com.muxia.qqzone.pojo.Reply;

import java.util.List;

public interface ReplyService {
    // 根据topicId，查询回复列表
    List<Reply> getReplyListByTopicId(Integer topicId);
}
