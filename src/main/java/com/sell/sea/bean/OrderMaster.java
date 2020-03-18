package com.sell.sea.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

/**
 * (OrderMaster)实体类
 *
 * @author makejava
 * @since 2020-03-06 14:35:45
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster implements Serializable {
    private static final long serialVersionUID = 409450728078173128L;

    @Id
    private String orderId;
    
    private String productId;
    //卖家名称
    private String buyerName;
    //卖家电话
    private String buyerPhone;
    //卖家地址
    private String buyerAddress;
    //卖家id
    private String buyerId;
    //订单金额
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