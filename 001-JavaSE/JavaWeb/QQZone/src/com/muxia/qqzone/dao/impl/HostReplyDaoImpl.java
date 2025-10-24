package com.muxia.qqzone.dao.impl;

import com.muxia.qqzone.dao.HostReplyDao;
import com.muxia.qqzone.myssm.dao.BaseDao;
import com.muxia.qqzone.pojo.HostReply;

public class HostReplyDaoImpl extends BaseDao<HostReply> implements HostReplyDao {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        String sql = "select * from t_host_reply where reply = ?";

        return load(sql,replyId);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        String sql = "insert into t_host_reply values(0,?,?,?,?)";
        executeUpdate(sql,hostReply.getContent(),hostReply.getHostReplyDate(),hostReply.getAuthor().getId(),hostReply.getReply().getId());
    }

    @Override
    public void delHostReplyByReplyId(Integer replyId) {
        executeUpdate("delete from t_host_reply where reply = ? ",replyId) ;
    }
}
