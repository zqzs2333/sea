package com.sell.sea.service.ServiceImpl;

import com.sell.sea.bean.OrderMaster;
import com.sell.sea.bean.UserInfo;
import com.sell.sea.dao.OrderMasterDao;
import com.sell.sea.service.OrderMasterService;
import com.sell.sea.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    OrderMasterDao orderMasterDao;
    @Autowired
    UserInfoService userInfoService;
    @Override
    public List<OrderMaster> findByProductId(String productId) {
        return orderMasterDao.findByProductId(productId);
    }

    @Override
    public List<OrderMaster> list() {
        return orderMasterDao.findAll();
    }

    @Override
    public List<OrderMaster> findByBAndBuyerName(String userName) {
        return orderMasterDao.findByBuyerName(userName);
    }

    @Override
    public OrderMaster findById(String orderId) {
        return orderMasterDao.findById(orderId).orElse(null);
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {


        return orderMasterDao.save(orderMaster);
    }

    @Override
    public OrderMaster delete(OrderMaster orderMaster) {
        return null;
    }
}
