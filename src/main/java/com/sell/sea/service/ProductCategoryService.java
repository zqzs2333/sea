package com.sell.sea.service;

import com.sell.sea.bean.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
     List<ProductCategory> findByTypeList(List<Integer> categoryTypeList);
     ProductCategory save(ProductCategory productCategory);

}
