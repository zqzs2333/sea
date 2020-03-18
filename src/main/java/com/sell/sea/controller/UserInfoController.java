package com.sell.sea.controller;

import com.sell.sea.Util.CookieUtil;
import com.sell.sea.Util.ResultVoUtil;
import com.sell.sea.bean.UserInfo;
import com.sell.sea.config.RedisConfig;
import com.sell.sea.enums.ResultEnums;
import com.sell.sea.exception.SellException;
import com.sell.sea.form.UserForm;
import com.sell.sea.resultVo.ResultVo;
import com.sell.sea.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("/login")
    public ResultVo login(@RequestParam(value = "userName") String userName,
                          @RequestParam(value = "userPass") String userPass,
                          HttpServletResponse response)
    {
        //验证数据库
        UserInfo userInfo = userInfoService.findByUserNameAndUserPass(userName, userPass);
        if (userInfo == null)
        {
            return ResultVoUtil.fail(401,"用户名密码错误");
        }
        else {
            //写redis
            String token= UUID.randomUUID().toString();
            Integer max= RedisConfig.max;
            stringRedisTemplate.opsForValue().set(String.format(RedisConfig.token,token),RedisConfig.salt+userInfo.getUserId(),max, TimeUnit.SECONDS);
            //设置cookie
            CookieUtil.set(response,"token",token,RedisConfig.max);

            return ResultVoUtil.success();


        }


    }
    @GetMapping("/logout")
    public ResultVo logout(HttpServletResponse response,
                           HttpServletRequest request){

        Cookie cookie = CookieUtil.get(request, "token");
        if (cookie != null)
        {
            stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisConfig.token,cookie.getValue()));
            CookieUtil.set(response,"token",null,0);
        }


        return ResultVoUtil.success(0,"登出成功");
    }
    @GetMapping("/wxsave")
    public ResultVo wxsave(@RequestParam(value = "wxName") String wxName,
                           @RequestParam(value = "icon") String icon){
        UserInfo byUserName = userInfoService.findByUserName(wxName);
        if (byUserName !=  null)
        {
            return ResultVoUtil.fail(333,"用户已存在");

        }
        UserInfo userInfo = new UserInfo();
        userInfo.setWxName(wxName);
        userInfo.setUserName(wxName);
        userInfo.setUserIcon(icon);
        userInfo.setUserPass("wxyonghuwumima");
        userInfoService.save(userInfo);
        return ResultVoUtil.success("保存成功");


    }
    @PostMapping("/signin")
    public ResultVo signin(@Valid UserForm userForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnums.param_error.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        UserInfo byUserName = userInfoService.findByUserName(userForm.getUserName());
        if (byUserName !=null)
        {
            return ResultVoUtil.fail(100,"用户名存在");
        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userForm,userInfo);
        userInfoService.save(userInfo);
        return ResultVoUtil.success(200,"注册就是那么成功");
    }
    @PostMapping("/motify")
    public ResultVo motify(@Valid UserForm userForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnums.param_error.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        UserInfo userInfo = userInfoService.findByUserName(userForm.getUserName());
        if (userInfo == null)
        {
            throw new SellException(ResultEnums.user_not_exist.getCode(),ResultEnums.user_not_exist.getMessage());

        }
        UserInfo saveUserInfo = new UserInfo();
        BeanUtils.copyProperties(userForm,saveUserInfo);
        userInfoService.save(saveUserInfo);
        return ResultVoUtil.success(200,"修改成功");

    }
    @GetMapping("/list")
    public ResultVo findAll()
    {
        List<UserInfo> userInfos = userInfoService.findAll();
        return ResultVoUtil.success(userInfos);
    }
    @GetMapping("/find")
    public ResultVo find(@RequestParam(value = "wxName") String wxName)
    {

        UserInfo byUserName = userInfoService.findByUserName(wxName);
        return ResultVoUtil.success(byUserName);
    }

}
