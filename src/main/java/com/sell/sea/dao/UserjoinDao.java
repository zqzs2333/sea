package com.sell.sea.dao;

import com.sell.sea.bean.UserJoin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserjoinDao extends JpaRepository<UserJoin,Integer> {
    List<UserJoin>  findByProductId(String productId);
    List<UserJoin> findByUserName(String userName);
    Integer countByUserName(String userName);
}
