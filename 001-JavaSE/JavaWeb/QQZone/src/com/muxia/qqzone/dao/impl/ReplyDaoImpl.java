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
}
