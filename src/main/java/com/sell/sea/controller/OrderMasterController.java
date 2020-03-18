package com.sell.sea.controller;

import com.sell.sea.Util.KeyUtil;
import com.sell.sea.Util.ResultVoUtil;
import com.sell.sea.bean.OrderMaster;
import com.sell.sea.enums.ResultEnums;
import com.sell.sea.exception.SellException;
import com.sell.sea.form.OrderMasterForm;
import com.sell.sea.resultVo.ResultVo;
import com.sell.sea.service.OrderMasterService;
import com.sell.sea.service.UserInfoService;
import com.sell.sea.service.UserJoinService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderMasterController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    OrderMasterService orderMasterService;
    @GetMapping("/list")
    public ResultVo list()
    {
        List<OrderMaster> list = orderMasterService.list();
        return ResultVoUtil.success(list);

    }
    @PostMapping("/create")
    @Transactional
    public ResultVo create(@Valid OrderMasterForm masterForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
        throw new SellException(ResultEnums.param_error.getCode(),bindingResult.getFieldError().getDefaultMessage());
    }
        String uniqueKey = KeyUtil.getUniqueKey();
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(masterForm,orderMaster);
        orderMaster.setOrderId(uniqueKey);
        orderMasterService.save(orderMaster);
        userInfoService.addLoveValue(orderMaster.getBuyerName(),orderMaster.getOrderAmout());

        return ResultVoUtil.success(0,"众筹订到创建成功");


    }
}
