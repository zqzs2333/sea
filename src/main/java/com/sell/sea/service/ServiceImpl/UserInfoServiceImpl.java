package com.sell.sea.service.ServiceImpl;

import com.sell.sea.bean.UserInfo;
import com.sell.sea.dao.UserDao;
import com.sell.sea.enums.ResultEnums;
import com.sell.sea.exception.SellException;
import com.sell.sea.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserDao userDao;
    @Override
    public UserInfo findByUserNameAndUserPass(String userName, String userPass) {


        return userDao.findByUserNameAndUserPass(userName,userPass);
    }

    @Override
    public UserInfo findByUserId(Integer userId) {
        return userDao.findById(userId).orElse(null);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userDao.save(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserInfo findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public UserInfo addLoveValue(String userName, Double loveValue) {
        UserInfo userInfo = userDao.findByUserName(userName);
        if (userInfo == null) {
            throw new SellException(ResultEnums.user_not_exist.getCode(),ResultEnums.user_not_exist.getMessage());
        }
        Double changeLoveValue = userInfo.getLoveValue();
        changeLoveValue =changeLoveValue+loveValue;
        userInfo.setLoveValue(changeLoveValue);
        userDao.save(userInfo);
        return null;
    }
}
