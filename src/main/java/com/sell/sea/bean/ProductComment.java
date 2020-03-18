package com.sell.sea.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

/**
 * (ProductComment)实体类
 *
 * @author makejava
 * @since 2020-03-06 14:35:47
 */
@Data
@Entity
@DynamicUpdate
public class ProductComment implements Serializable {
    private static final long serialVersionUID = 141599798339885167L;

    @Id
    private String commentId;
    
    private String productId;
    
    private String commentContext;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;


    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}