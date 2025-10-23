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
}
