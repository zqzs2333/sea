package com.sell.sea.form;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderMasterForm {


    //卖家名称 必须
    private String buyerName;
    //卖家电话 必须
    private String buyerPhone;
    //卖家地址 必须
    private String buyerAddress;
    //卖家id
    private String buyerId;
    //订单金额 必须
    private Double orderAmout;
    //订单状态
    private Integer orderStatus;
    //支付状态
    private Integer payStatus;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
