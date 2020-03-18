package com.sell.sea.service;

import com.sell.sea.bean.UserJoin;

import java.util.List;

public interface UserJoinService {
    List<UserJoin> findByProductId(String productId);
    List<UserJoin> findByUserName(String userName);
    Integer countByUserName(String userName);
}
