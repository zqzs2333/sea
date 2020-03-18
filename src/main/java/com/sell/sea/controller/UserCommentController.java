package com.sell.sea.controller;

import com.sell.sea.Util.ResultVoUtil;
import com.sell.sea.bean.UserComment;
import com.sell.sea.form.UserCommentForm;
import com.sell.sea.resultVo.ResultVo;
import com.sell.sea.service.ProductInfoService;
import com.sell.sea.service.UserCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class UserCommentController {
    @Autowired
    ProductInfoService productInfoService;
    @Autowired
    UserCommentService userCommentService;
    @GetMapping("/create")
    public ResultVo create(@RequestParam(value = "userName" )String userName,
                           @RequestParam(value = "productId" )String productId,
                           @Valid UserCommentForm userCommentForm){

        UserComment userComment = new UserComment();
        BeanUtils.copyProperties(userCommentForm,userComment);
        userComment.setUserName(userName);
        userComment.setProductId(productId);
        userCommentService.save(userComment);
        return ResultVoUtil.success(200,"为项目评论添加成功");
    }

    @GetMapping("/comments/productId")
    public ResultVo findCommentsByProductId(@RequestParam(value = "productId") String productId)
    {
        List<UserComment> comments = userCommentService.findByProductId(productId);
        System.out.println(comments);
        return ResultVoUtil.success(comments);
    }
}
