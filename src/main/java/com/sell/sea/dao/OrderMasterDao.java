package com.sell.sea.dao;

import com.sell.sea.bean.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
    List<OrderMaster> findByProductId(String productId);
    List<OrderMaster> findByBuyerName(String userName);
}
