package com.muxia.qqzone.service.impl;

import com.muxia.qqzone.dao.TopicDao;
import com.muxia.qqzone.pojo.Reply;
import com.muxia.qqzone.pojo.Topic;
import com.muxia.qqzone.pojo.UserBasic;
import com.muxia.qqzone.service.ReplyService;
import com.muxia.qqzone.service.TopicService;
import com.muxia.qqzone.service.UserBasicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao;
    private UserBasicService userBasicService ;
    private ReplyService replyService;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDao.getTopicList(userBasic);
    }

    @Override
    public Topic getTopicById(Integer id) {
        return topicDao.getTopicById(id);
    }

    @Override
    public Topic getTopicWithReplyList(Integer id) {
        // 查询topic信息,但是这个topic里面的作者只有id值，没有头像和昵称，而我们页面上需要展示作者的头像和昵称
        Topic topic = getTopicById(id);
        // 查询这篇日志的作者信息（主要是头像和昵称）
        UserBasic author = userBasicService.getUserBasicById(topic.getAuthor().getId());
        topic.setAuthor(author);
        // 获取 回复信息
        List<Reply> replyList = replyService.getReplyListByTopicId(id);
        // 设置 属性
        topic.setReplyList(replyList);
        return topic;
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.addTopic(topic);
    }

    @Override
    public void delTopic(Integer id) {
        //1.删除关联的回复信息
        replyService.delReplyByTopicId(id);

        //2.删除日志信息
        topicDao.delTopic(id);
    }
}
