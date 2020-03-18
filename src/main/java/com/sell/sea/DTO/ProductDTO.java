package com.sell.sea.DTO;

import com.sell.sea.bean.UserComment;
import com.sell.sea.bean.UserJoin;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
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
    //小图
    private String productIcon;
    //0 封禁（失效） 1 正常 2审核中 4 审核失败
    private Integer productState;
    private String userName;
    private Double value;
    private List<UserJoin> userJoin;/*加入项目的用户*/
    private List<UserComment> userComment;/*用户的评论*/
}
