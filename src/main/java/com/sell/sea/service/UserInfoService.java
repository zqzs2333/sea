package com.sell.sea.service;

import com.sell.sea.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo findByUserNameAndUserPass(String userName,String userPass);
    UserInfo findByUserId(Integer userId);
    UserInfo save(UserInfo userInfo);
    List<UserInfo> findAll();
    UserInfo findByUserName(String userName);
    UserInfo addLoveValue(String userName,Double loveValue);
}
