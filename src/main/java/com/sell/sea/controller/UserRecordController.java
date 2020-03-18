package com.sell.sea.controller;

import com.sell.sea.Util.ResultVoUtil;
import com.sell.sea.bean.ProductInfo;
import com.sell.sea.bean.UserRecord;
import com.sell.sea.bean.UserStar;
import com.sell.sea.resultVo.ResultVo;
import com.sell.sea.service.ProductInfoService;
import com.sell.sea.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/record")
public class UserRecordController {
    @Autowired
    ProductInfoService productInfoService;
    @Autowired
    UserRecordService userRecordService;

    @GetMapping("/find")
    public ResultVo findByUserName(@RequestParam(value = "userName") String userName){
        List<UserRecord> userNames = userRecordService.findByUserName(userName);
        List<ProductInfo> list = new ArrayList<>();
        for (UserRecord userRecord : userNames) {
            ProductInfo productInfo = productInfoService.findone(userRecord.getProductId());
            list.add(productInfo);
        }
        return ResultVoUtil.success(list);
    }

    @GetMapping("/add")
    public ResultVo add(@RequestParam(value = "userName")String username,
                        @RequestParam(value = "productId") String productId){
        UserRecord byUserNameAndProductId = userRecordService.findByUserNameAndProductId(username, productId);
        if (byUserNameAndProductId != null)
        {
            return ResultVoUtil.fail(333,"已经有记录了");
        }
        UserRecord userRecord = new UserRecord();
        userRecord.setUserName(username);
        userRecord.setProductId(productId);
        userRecordService.save(userRecord);
        return ResultVoUtil.success(0,"记录成功");

    }
    @GetMapping("/delete")
    public ResultVo delete(@RequestParam(value = "userName")String username,
                           @RequestParam(value = "productId") String productId)
    {
        UserRecord byUserNameAndProductId = userRecordService.findByUserNameAndProductId(username, productId);
        if (byUserNameAndProductId == null) {
            return ResultVoUtil.fail(333,"没有这条浏览记录");
        }
        userRecordService.deleteByUserNameAndProductId(username,productId);
        return ResultVoUtil.success(0,"删除成功");
    }
}
