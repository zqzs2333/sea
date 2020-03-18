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
 * (UserComment)实体类
 *
 * @author makejava
 * @since 2020-03-09 15:35:57
 */
@Data
@Entity
@DynamicUpdate
public class UserComment implements Serializable {
    private static final long serialVersionUID = -69588765972134170L;
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    //用户
    private Integer userId;
    
    private String productId;
    
    private String userComment;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

    private String userName;




}