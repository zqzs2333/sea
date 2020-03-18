package com.sell.sea.dao;

import com.sell.sea.bean.UserRecord;
import com.sell.sea.bean.UserStar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRecordDao extends JpaRepository<UserRecord,Integer> {
    List<UserRecord> findByUserName(String userName);
    UserRecord findByUserNameAndProductId(String userName,String productId);
    UserRecord deleteByUserNameAndProductId(String userName,String productId);
}
