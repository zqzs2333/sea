package com.sell.sea.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * (UserJoin)实体类
 *
 * @author makejava
 * @since 2020-03-09 15:32:49
 */
@Data
@Entity
@DynamicUpdate
public class UserJoin implements Serializable {
    private static final long serialVersionUID = 573031009805980577L;
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer joinId;
    //用户
    private Integer userId;
    
    private String productId;
    //创建时间
    private Date createTime;
    private Double value;
    //修改时间
    private Date updateTime;
    private String userName;

}