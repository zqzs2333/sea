package com.sell.sea.dao;

import com.sell.sea.bean.UserComment;
import com.sell.sea.bean.UserJoin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCommentDao extends JpaRepository<UserComment,Integer> {
    List<UserComment> findByProductId(String productId);
}
