package com.sell.sea.service;

import com.sell.sea.DTO.ProductDTO;
import com.sell.sea.bean.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    List<ProductDTO> findByHotList();
    List<ProductDTO> list();
    List<ProductDTO> findByType(Integer categoryId);
    List<ProductDTO> findByUserName(String userName);
    ProductInfo findone(String productId);
    ProductInfo delete(String productId);
    ProductInfo save(ProductInfo productInfo);
    List<ProductInfo> findByProductNameLike(String productName);
}
