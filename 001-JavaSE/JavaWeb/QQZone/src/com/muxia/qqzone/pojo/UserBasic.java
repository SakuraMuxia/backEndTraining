package com.muxia.qqzone.pojo;

import java.util.List;

/*
* 基本用户信息
* */
public class UserBasic {

    private Integer id;
    private String loginId;
    private String pwd;
    private String nickName;
    private String headImg;

    // 与 用户详情表 1 对 1 关系 1:1 PK
    private UserDetail userDetail;
    // 与 日志表 1对多关系
    private List<Topic> topicList;
    // 与 好友表 多对多关系
    private List<UserBasic> friendList;

    public UserBasic(Integer id) {
        this.id = id;
    }

    public UserBasic(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<UserBasic> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<UserBasic> friendList) {
        this.friendList = friendList;
    }
}
