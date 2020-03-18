package com.sell.sea.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

/**
 * (ProductInfo)实体类
 *
 * @author makejava
 * @since 2020-03-06 14:35:48
 */
@Data
@Entity
@DynamicUpdate
public class ProductInfo implements Serializable {
    private static final long serialVersionUID = 667287364101809540L;

    @Id
    private String productId;
    //项目名称
    private String productName;
    //商品总众筹金额
    private Double productTotalPrise;
    //商品已经筹集金额
    private Double productPrise;
    //项目描述
    private String productDescription;
    private Integer productType;
    private Integer isHot;
    //小图
    private String productIcon;
    //1 封禁（失效） 0 正常 2审核中 4 审核失败
    private Integer productState;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    private String userName;



}