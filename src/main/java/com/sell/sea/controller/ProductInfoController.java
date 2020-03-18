package com.sell.sea.controller;

import com.sell.sea.DTO.ProductDTO;
import com.sell.sea.Util.KeyUtil;
import com.sell.sea.Util.ResultVoUtil;
import com.sell.sea.bean.ProductCategory;
import com.sell.sea.bean.ProductInfo;
import com.sell.sea.enums.ResultEnums;
import com.sell.sea.exception.SellException;
import com.sell.sea.form.ProductInfoForm;
import com.sell.sea.resultVo.ResultVo;
import com.sell.sea.service.ProductCategoryService;
import com.sell.sea.service.ProductInfoService;
import com.sell.sea.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductInfoController {
    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    ProductInfoService productInfoService;
    @Autowired
    UserInfoService userInfoService;
    @GetMapping("/mine")
    public ResultVo mine(@RequestParam(value = "productId") String productId,
                         @RequestParam(value = "userName") String userName)
    {
        ProductInfo productInfo = productInfoService.findone(productId);
        if (!userName.equals(productInfo.getUserName())) {
            return ResultVoUtil.fail(333,"不是该用户的");
        }
        return ResultVoUtil.success(0,"是该用户的");
    }
    @GetMapping("/findone")
    public ResultVo findone(@RequestParam(value = "productId") String productId)
    {
        ProductInfo findone = productInfoService.findone(productId);
        return ResultVoUtil.success(findone);
    }
    @GetMapping("/findByProductName")
    public ResultVo findByProductNameLike(@RequestParam(value = "productName") String productName)
    {
        List<ProductInfo> byProductNameLike = productInfoService.findByProductNameLike(productName);
        return ResultVoUtil.success(byProductNameLike);
    }

    @GetMapping("/findHotList")
    public ResultVo findHotList(){
        return ResultVoUtil.success(productInfoService.findByHotList());
    }
    @GetMapping("/list")
    public ResultVo list(){
        return ResultVoUtil.success(productInfoService.list());
    }
    @GetMapping("/findByName")
    public ResultVo findByName(@RequestParam(value = "userName") String userName){
        return ResultVoUtil.success(productInfoService.findByUserName(userName));
    }
    @GetMapping("/findByType")
    public ResultVo findByType(@RequestParam(value = "categoryType") Integer categoryType)
    {
        List<Integer> list =new ArrayList<>();
        list.add(categoryType);
        List<ProductCategory> typeList = productCategoryService.findByTypeList(list);
        if (typeList.size() == 0) {
            throw  new SellException(ResultEnums.type_not_exist.getCode(),ResultEnums.type_not_exist.getMessage());
        }
        return ResultVoUtil.success(productInfoService.findByType(categoryType));
    }
    @PostMapping("/motify")
    public ResultVo motify(@Valid ProductInfoForm productInfoForm,
                           @RequestParam(value = "productId") String productId,
                           BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnums.param_error.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        ProductInfo productInfo = productInfoService.findone(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnums.product_not_exist.getCode(),ResultEnums.product_not_exist.getMessage());
        }
        BeanUtils.copyProperties(productInfoForm,productInfo);
        productInfoService.save(productInfo);
        return ResultVoUtil.success(200,"项目修改成功");

    }
    @GetMapping("/create")
    public ResultVo create(@Valid ProductInfoForm productInfoForm,BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnums.param_error.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        String uniqueKey = KeyUtil.getUniqueKey();
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productInfoForm,productInfo);
        productInfo.setProductId(uniqueKey);
        productInfoService.save(productInfo);
        return ResultVoUtil.success(200,"项目创建成功");

    }
    @GetMapping("/add/value")
    public ResultVo addLoveValue(@RequestParam(value = "productId") String prodcutId,
                                 @RequestParam(value = "value") Double value)
    {
        ProductInfo productInfo = productInfoService.findone(prodcutId);
        Double chanageProductPrise = productInfo.getProductPrise();
        chanageProductPrise =chanageProductPrise+value;
        productInfo.setProductPrise(chanageProductPrise);
        productInfoService.save(productInfo);
        userInfoService.addLoveValue(productInfo.getUserName(),value);
        return ResultVoUtil.success(0,"添加爱心值成功！");
    }


}
