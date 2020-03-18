package com.sell.sea.service.ServiceImpl;

import com.sell.sea.bean.UserComment;
import com.sell.sea.dao.UserCommentDao;
import com.sell.sea.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentServiceImpl implements UserCommentService {
    @Autowired
    UserCommentDao userCommentDao;
    @Override
    public UserComment save(UserComment userComment) {
        return userCommentDao.save(userComment);
    }

    @Override
    public List<UserComment> findByProductId(String productId) {
        return userCommentDao.findByProductId(productId);
    }
}
