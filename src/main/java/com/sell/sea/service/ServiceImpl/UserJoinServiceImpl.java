package com.sell.sea.service.ServiceImpl;

import com.sell.sea.bean.UserJoin;
import com.sell.sea.dao.UserjoinDao;
import com.sell.sea.service.UserJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJoinServiceImpl implements UserJoinService {
    @Autowired
    UserjoinDao userjoinDao;
    @Override
    public List<UserJoin> findByProductId(String productId) {
        return userjoinDao.findByProductId(productId);
    }

    @Override
    public List<UserJoin> findByUserName(String userName) {
        return userjoinDao.findByUserName(userName);
    }

    @Override
    public Integer countByUserName(String userName) {
        return userjoinDao.countByUserName(userName);
    }
}
