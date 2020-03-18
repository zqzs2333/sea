package com.sell.sea.dao;

import com.sell.sea.bean.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductType(Integer categoryId);
    List<ProductInfo> findByIsHot(Integer isHot);
    List<ProductInfo> findByUserName(String userName);
    List<ProductInfo> findByProductNameLike(String productName);
    ProductInfo deleteByProductId(String productId);

}
