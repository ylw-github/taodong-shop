package com.ylw.common.core.entity;

import lombok.Data;

import java.util.Date;

/**
 * description: BaseDo
 * create by: YangLinWei
 * create time: 2020/3/3 4:44 下午
 */
@Data
public class BaseDo {
    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * id
     */
    private Long id;

    /**
     * 是否可用 0可用 1不可用
     */
    private Long isAvailability;
}
