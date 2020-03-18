package com.sell.sea.controller;

import com.sell.sea.DTO.ProductDTO;
import com.sell.sea.Util.ResultVoUtil;
import com.sell.sea.bean.ProductInfo;
import com.sell.sea.bean.UserJoin;
import com.sell.sea.dao.ProductInfoDao;
import com.sell.sea.resultVo.ResultVo;
import com.sell.sea.service.ProductInfoService;
import com.sell.sea.service.UserInfoService;
import com.sell.sea.service.UserJoinService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userandproduct")
public class UserJoinController {
    @Autowired
    ProductInfoDao productInfoDao;
    @Autowired
    UserJoinService userJoinService;
    @GetMapping("/users")
    public ResultVo findUsersByProductId(@RequestParam(value = "productId") String productId)
    {
        List<UserJoin> joinList = userJoinService.findByProductId(productId);
        return ResultVoUtil.success(joinList);
    }
    @GetMapping("/products")
    public ResultVo findProductsByUserName(@RequestParam(value = "userName") String userName)
    {
        List<UserJoin> joinList = userJoinService.findByUserName(userName);
        List<ProductDTO> productInfoList =new ArrayList<>();
        for (UserJoin userJoin : joinList) {
            ProductInfo productInfo = productInfoDao.findById(userJoin.getProductId()).orElse(null);
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productInfo,productDTO);
            productDTO.setValue(userJoin.getValue());
            productInfoList.add(productDTO);
        }
        return ResultVoUtil.success(productInfoList);
    }
    @GetMapping("/count/users")
    public ResultVo countByUsername(@RequestParam(value = "userName") String userName){
        Integer integer = userJoinService.countByUserName(userName);
        return ResultVoUtil.success(integer);
    }
}
