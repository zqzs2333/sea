package com.sell.sea.service;

import com.sell.sea.bean.OrderMaster;

import java.util.List;

public interface OrderMasterService {
    List<OrderMaster> findByProductId(String productId);
    List<OrderMaster> list();
    List<OrderMaster> findByBAndBuyerName(String userName);
    OrderMaster findById(String orderId);
    OrderMaster save(OrderMaster orderMaster);
    OrderMaster delete(OrderMaster orderMaster);

}
