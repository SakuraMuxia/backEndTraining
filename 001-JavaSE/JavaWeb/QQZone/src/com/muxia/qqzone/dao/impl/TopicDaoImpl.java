package com.muxia.qqzone.dao.impl;

import com.muxia.qqzone.dao.TopicDao;
import com.muxia.qqzone.myssm.dao.BaseDao;
import com.muxia.qqzone.pojo.Topic;
import com.muxia.qqzone.pojo.UserBasic;

import java.util.List;

public class TopicDaoImpl extends BaseDao<Topic> implements TopicDao {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        Integer id = userBasic.getId();
        String sql = "select * from t_topic where author = ?";
        return executeQuery(sql,id);
    }

    @Override
    public Topic getTopicById(Integer id) {
        return load("select * from t_topic where id = ? " , id);
    }

    @Override
    public void addTopic(Topic topic) {
        String sql = "insert into t_topic values(0,?,?,?,?)";
        executeUpdate(sql,topic.getTitle(),topic.getContent(),topic.getTopicDate(),topic.getAuthor().getId());
    }

    @Override
    public void delTopic(Integer id) {
        executeUpdate("delete from t_topic where id = ?" , id);
    }
}
