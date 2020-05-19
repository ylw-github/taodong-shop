package com.ylw.service.integral.mapper.entity;

import lombok.Data;

import java.util.Date;

@Data
public class IntegralEntity {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 支付ID
     */
    private String paymentId;
    /**
     * 积分
     */
    private Long integral;
    /**
     * 是否可用
     */
    private Integer availability;
    /**
     * 乐观锁
     */
    private Integer revision;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updatedBy;
    /**
     * 更新时间
     */
    private Date updatedTime;
}
