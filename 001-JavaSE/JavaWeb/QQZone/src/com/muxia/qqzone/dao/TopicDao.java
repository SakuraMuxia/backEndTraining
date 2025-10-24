package com.muxia.qqzone.dao;

import com.muxia.qqzone.pojo.Topic;
import com.muxia.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDao {
    // 获取 topic列表
    List<Topic> getTopicList(UserBasic userBasic);
    // 获取 topic 数据 通过id
    Topic getTopicById(Integer id);

    void addTopic(Topic topic);

    void delTopic(Integer id);
}
