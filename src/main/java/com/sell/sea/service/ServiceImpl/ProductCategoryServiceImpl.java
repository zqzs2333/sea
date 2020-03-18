package com.sell.sea.service.ServiceImpl;

import com.sell.sea.bean.ProductCategory;
import com.sell.sea.bean.UserComment;
import com.sell.sea.dao.ProductCategoryDao;
import com.sell.sea.dao.UserCommentDao;
import com.sell.sea.dao.UserjoinDao;
import com.sell.sea.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findById(categoryId).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByTypeList(List<Integer> categoryTypeList) {

        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
