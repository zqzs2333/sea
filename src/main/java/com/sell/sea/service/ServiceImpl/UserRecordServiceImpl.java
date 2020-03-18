package com.sell.sea.service.ServiceImpl;

import com.sell.sea.bean.UserRecord;
import com.sell.sea.dao.UserRecordDao;
import com.sell.sea.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRecordServiceImpl implements UserRecordService {
    @Autowired
    UserRecordDao userRecordDao;
    @Override
    public List<UserRecord> findByUserName(String userName) {
        return userRecordDao.findByUserName(userName);
    }

    @Override
    public UserRecord findByUserNameAndProductId(String userName, String productId) {
        return userRecordDao.findByUserNameAndProductId(userName,productId);
    }

    @Override
    public UserRecord save(UserRecord userRecord) {
        return userRecordDao.save(userRecord);
    }

    @Override
    @Transactional
    public UserRecord deleteByUserNameAndProductId(String userName, String productId) {
        return userRecordDao.deleteByUserNameAndProductId(userName,productId);
    }
}
