package com.tk.medical.service;

import com.tk.medical.bean.IntegrationAuthenticationEntity;
import com.tk.medical.bean.UserPojo;

/**
 * 集成认证器接口
 */
public interface IntegrationAuthenticator {
    /**
     * 处理集成认证
     *
     * @param entity
     * @return
     */
    UserPojo authenticate(IntegrationAuthenticationEntity entity);

    /**
     * 预处理
     */
    void prepare(IntegrationAuthenticationEntity entity);

    /**
     * 判断是否支持认证类型
     *
     * @param entity
     * @return
     */
    boolean support(IntegrationAuthenticationEntity entity);

    /**
     * 认证结束后执行
     *
     * @param entity
     */
    void complete(IntegrationAuthenticationEntity entity);

}
