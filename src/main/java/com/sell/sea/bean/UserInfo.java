package com.sell.sea.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

/**
 * (UserInfo)实体类
 *
 * @author makejava
 * @since 2020-03-06 14:35:48
 */
@Data
@Entity
@DynamicUpdate
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 728448578594062346L;
    //用户id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    //用户名字
    private String userName;
    //用户地址
    private String userAddress;
    //用户手机
    private String userPhone;
    //用户总账户
    private Double userAccount;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    
    private String userPass;
    private Double loveValue;
    private String userIcon;
    private String wxName;



}