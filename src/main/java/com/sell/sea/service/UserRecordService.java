package com.sell.sea.service;

import com.sell.sea.bean.UserRecord;

import java.util.List;

public interface UserRecordService {
    List<UserRecord> findByUserName(String userName);
    UserRecord findByUserNameAndProductId(String userName,String productId);
    UserRecord save(UserRecord userRecord);
    UserRecord deleteByUserNameAndProductId(String userName,String productId);
}
