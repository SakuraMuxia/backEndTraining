package com.muxia.qqzone.service;

import com.muxia.qqzone.pojo.UserBasic;

public interface UserBasicService {
    UserBasic login(String loginId,String pwd);
}
