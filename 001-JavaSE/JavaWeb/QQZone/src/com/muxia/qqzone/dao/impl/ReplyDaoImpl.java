package com.muxia.qqzone.dao.impl;

import com.muxia.qqzone.dao.ReplyDao;
import com.muxia.qqzone.myssm.dao.BaseDao;
import com.muxia.qqzone.pojo.Reply;

import java.util.List;

public class ReplyDaoImpl extends BaseDao<Reply> implements ReplyDao {
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        return executeQuery("select * from t_reply where topic = ? " , topicId);
    }

    @Override
    public void addReply(Reply reply) {
        executeUpdate("insert into t_reply values(0,?,?,?,?)",reply.getContent(),reply.getReplyDate(),reply.getAuthor().getId(),reply.getTopic().getId());
    }

    @Override
    public void delReplyById(Integer replyId) {
        executeUpdate("delete from t_reply where id = ? " ,replyId);
    }
}
