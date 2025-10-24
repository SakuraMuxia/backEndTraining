package com.muxia.qqzone.dao;

import com.muxia.qqzone.pojo.HostReply;

public interface HostReplyDao {
    HostReply getHostReplyByReplyId(Integer replyId);

    void addHostReply(HostReply hostReply);

    void delHostReplyByReplyId(Integer replyId);
}
