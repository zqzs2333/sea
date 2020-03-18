package com.sell.sea.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class ProductInfoForm {

    //项目名称
    @NotEmpty
    private String productName;
    @NotEmpty
    private String userName;
    //商品总众筹金额
    private Double productTotalPrise;
    //商品已经筹集金额
    private Double productPrise =0.00;
    //项目描述
    private String productDescription;
    private Integer productState=0;
    private Integer productType;
    private Integer isHot =0;
    //小图
    private String productIcon;

}