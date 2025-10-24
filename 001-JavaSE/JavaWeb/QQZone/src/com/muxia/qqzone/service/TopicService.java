package com.muxia.qqzone.service;

import com.muxia.qqzone.pojo.Topic;
import com.muxia.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {

    // 获取指定用户的日志列表信息
    List<Topic> getTopicList(UserBasic userBasic);

    // 根据Id获取topic信息，详细数据
    Topic getTopicById(Integer id);

    // 根据id获取topic信息同时携带回复信息
    Topic getTopicWithReplyList(Integer id);

    void addTopic(Topic topic);

    void delTopic(Integer id);
}
