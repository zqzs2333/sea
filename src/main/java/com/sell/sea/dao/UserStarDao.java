package com.sell.sea.dao;

import com.sell.sea.bean.UserStar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStarDao  extends JpaRepository<UserStar,Integer> {
    List<UserStar> findByUserName(String userName);
    UserStar findByUserNameAndProductId(String userName,String productId);
    Integer deleteByUserNameAndProductId(String userName,String productId);

}
