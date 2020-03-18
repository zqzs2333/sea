package com.sell.sea.controller;

import com.sell.sea.Util.ResultVoUtil;
import com.sell.sea.bean.ProductInfo;
import com.sell.sea.bean.UserStar;
import com.sell.sea.exception.SellException;
import com.sell.sea.resultVo.ResultVo;
import com.sell.sea.service.ProductInfoService;
import com.sell.sea.service.UserStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/star")
public class UserStarController {
    @Autowired
    UserStarService userStarService;
    @Autowired
    ProductInfoService productInfoService;
    @GetMapping("/find")
    public ResultVo findByUserName(@RequestParam(value = "userName") String userName){
        List<UserStar> userStars = userStarService.findByUserName(userName);
        List<ProductInfo> list = new ArrayList<>();
        for (UserStar userStar : userStars) {
            ProductInfo productInfo = productInfoService.findone(userStar.getProductId());
            list.add(productInfo);
        }
        return ResultVoUtil.success(list);


    }
    @GetMapping("/add")
    public ResultVo add(@RequestParam(value = "userName")String username,
                        @RequestParam(value = "productId") String productId){
        UserStar userNameAndProductId = userStarService.findByUserNameAndProductId(username, productId);
        if (userNameAndProductId != null)
        {
            return ResultVoUtil.fail(333,"收藏不成功，你已经收藏了");
        }
        UserStar userStar = new UserStar();
        userStar.setUserName(username);
        userStar.setProductId(productId);
        userStarService.save(userStar);
        return ResultVoUtil.success(0,"收藏成功");

    }
    @GetMapping("/delete")
    public ResultVo delete(@RequestParam(value = "userName")String username,
                           @RequestParam(value = "productId") String productId){
        UserStar byUserNameAndProductId = userStarService.findByUserNameAndProductId(username, productId);
        if (byUserNameAndProductId == null) {
            return ResultVoUtil.fail(333,"该用户没有该收藏！");
        }
        userStarService.deleteByUserNameAndProductId(username,productId);
        return ResultVoUtil.success(0,"删除成功");
    }
}
