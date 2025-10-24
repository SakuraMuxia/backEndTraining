package com.muxia.qqzone.pojo;

import java.time.LocalDateTime;
import java.util.Date;
/*
* 别人回复铁子表
* */

public class Reply {

    private Integer id ;
    private String content ;
    private LocalDateTime replyDate ;
    // 与 基本信息表 多 对 1 关系
    private UserBasic author ;  //M:1
    // 与 话题表 多 对 1 关系
    private Topic topic ;   //M:1
    // 与 主人回复表 1 对 1 关系
    private HostReply hostReply ;

    public Reply() {
    }

    public Reply(Integer id) {
        this.id = id;
    }

    public Reply(String content, LocalDateTime replyDate, UserBasic author, Topic topic) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDateTime replyDate) {
        this.replyDate = replyDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }
}
