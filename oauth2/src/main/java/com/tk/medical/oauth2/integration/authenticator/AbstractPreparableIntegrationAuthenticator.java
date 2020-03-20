package com.tk.medical.oauth2.integration.authenticator;


import com.tk.medical.oauth2.integration.IntegrationAuthenticationEntity;

/**
 * @Author: yugu
 * @CreateDate: 2018/9/26$ 下午9:26$
 * @Description: 集成认证-认证器抽象类
 */
public abstract class AbstractPreparableIntegrationAuthenticator implements IntegrationAuthenticator {

    @Override
    public void prepare(IntegrationAuthenticationEntity entity) {

    }

    @Override
    public void complete(IntegrationAuthenticationEntity entity) {

    }
}
