package com.sell.sea.service;

import com.sell.sea.bean.UserComment;

import java.util.List;

public interface UserCommentService {
    UserComment save(UserComment userComment);
    List<UserComment> findByProductId(String productId);
}
