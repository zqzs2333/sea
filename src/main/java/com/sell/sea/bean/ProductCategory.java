package com.sell.sea.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

/**
 * (ProductCategory)实体类
 *
 * @author makejava
 * @since 2020-03-06 14:35:47
 */
@Data
@Entity
@DynamicUpdate
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 764016100841518245L;

    @Id
    private Integer categoryId;
    //类目名称
    private String categoryName;
    //类目编号
    private Integer categoryType;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;



}