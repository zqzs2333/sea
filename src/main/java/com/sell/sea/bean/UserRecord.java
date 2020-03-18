package com.sell.sea.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

/**
 * (UserRecord)实体类
 *
 * @author makejava
 * @since 2020-03-14 14:58:10
 */
@Entity
@Data
@DynamicUpdate
public class UserRecord implements Serializable {
    private static final long serialVersionUID = 528248129817055962L;
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;
    //用户
    private Integer userId;
    
    private String userName;
    
    private String productId;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;




}