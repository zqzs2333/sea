package com.sell.sea.controller;

import com.sell.sea.Util.ResultVoUtil;
import com.sell.sea.bean.ProductCategory;
import com.sell.sea.enums.ResultEnums;
import com.sell.sea.exception.SellException;
import com.sell.sea.form.CategoryForm;
import com.sell.sea.resultVo.ResultVo;
import com.sell.sea.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;
    @GetMapping("/list")
    public ResultVo list(){
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        return ResultVoUtil.success(productCategoryList);

    }
    @GetMapping("/find")
    public ResultVo findone(@RequestParam("categoryId") Integer categoryId)
    {
        if (categoryId == null)
        {
            return ResultVoUtil.fail(100,"categoryId错误");
        }
        ProductCategory result = productCategoryService.findOne(categoryId);
        return ResultVoUtil.success(result);
    }

    @PostMapping("/motify")
    public ResultVo add(@Valid CategoryForm categoryForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnums.param_error.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        ProductCategory productCategory = productCategoryService.findOne(categoryForm.getCategoryId());
        BeanUtils.copyProperties(categoryForm,productCategory);
        productCategoryService.save(productCategory);
        return ResultVoUtil.success();

    }
}
