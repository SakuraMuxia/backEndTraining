package com.muxia.qqzone.dao;

import com.muxia.qqzone.pojo.Reply;

import java.util.List;

public interface ReplyDao {
    List<Reply> getReplyListByTopicId(Integer topicId);

    void addReply(Reply reply);

    void delReplyById(Integer replyId);
}
