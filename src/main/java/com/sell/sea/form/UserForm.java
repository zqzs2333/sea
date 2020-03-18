package com.sell.sea.form;

import lombok.Data;

import java.util.Date;

@Data
public class UserForm {

    private String userName;

    private String userPass;
    //用户地址
    private String userAddress;
    //用户手机
    private String userPhone;

    private String userIcon;



}
