package com.sell.sea.dao;

import com.sell.sea.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserInfo,Integer> {
    UserInfo findByUserNameAndUserPass(String userName,String userPass);
    UserInfo findByUserName(String userName);
}
