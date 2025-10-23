package com.muxia.qqzone.pojo;

import java.time.LocalDateTime;
import java.util.List;

/*
* 日志-帖子
* */
public class Topic {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime topicDate;
    // 与 基本信息表 多对1关系
    private UserBasic author;
    // 与 回复表 1对多关系
    private List<Reply> replyList;

    public Topic(){}

    public Topic(Integer id){
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(LocalDateTime topicDate) {
        this.topicDate = topicDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
