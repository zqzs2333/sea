package com.sell.sea.service.ServiceImpl;

import com.sell.sea.bean.UserStar;
import com.sell.sea.dao.UserStarDao;
import com.sell.sea.service.UserStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserStarServiceImpl implements UserStarService {
    @Autowired
    UserStarDao userStarDao;
    @Override
    public List<UserStar> findByUserName(String userName) {
        return userStarDao.findByUserName(userName);
    }

    @Override
    public UserStar save(UserStar userStar) {
        return userStarDao.save(userStar);
    }

    @Override
    public UserStar findByUserNameAndProductId(String userName, String productId) {
        return userStarDao.findByUserNameAndProductId(userName,productId);
    }

    @Override
    @Transactional
    public Integer deleteByUserNameAndProductId(String userName, String productId) {
        return userStarDao.deleteByUserNameAndProductId(userName,productId);
    }
}
