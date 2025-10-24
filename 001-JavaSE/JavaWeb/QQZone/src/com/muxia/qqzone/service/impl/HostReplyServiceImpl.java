package com.muxia.qqzone.service.impl;

import com.muxia.qqzone.dao.HostReplyDao;
import com.muxia.qqzone.pojo.HostReply;
import com.muxia.qqzone.service.HostReplyService;

public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDao hostReplyDao;
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDao.getHostReplyByReplyId(replyId);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        hostReplyDao.addHostReply(hostReply);
    }

    @Override
    public void delHostReplyByReplyId(Integer replyId) {
        hostReplyDao.delHostReplyByReplyId(replyId);
    }
}
