package com.muxia.qqzone.service;

import com.muxia.qqzone.pojo.HostReply;

public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);

    void addHostReply(HostReply hostReply);

    void delHostReplyByReplyId(Integer replyId);
}
