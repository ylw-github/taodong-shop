package com.ylw.api.weixin.entity;

import lombok.Data;

@Data
public class AppEntity {

    /**
     * 应用id
     */
    private String appId;
    /**
     * 应用密钥
     */
    private String appSecret;

    public AppEntity() {

    }

    public AppEntity(String appId, String appSecret) {
        super();
        this.appId = appId;
        this.appSecret = appSecret;
    }

}