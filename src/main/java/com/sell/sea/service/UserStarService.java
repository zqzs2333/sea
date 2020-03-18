package com.sell.sea.service;

import com.sell.sea.bean.UserStar;

import java.util.List;

public interface UserStarService {
    List<UserStar> findByUserName(String userName);
    UserStar save(UserStar userStar);
    UserStar findByUserNameAndProductId(String userName,String productId);
    Integer deleteByUserNameAndProductId(String userName,String productId);
}
