package com.tk.medical.oauth.common;

import com.tk.medical.oauth.bean.IntegrationAuthenticationEntity;
import com.tk.medical.oauth.service.IntegrationAuthenticator;

public abstract class AbstractPreparableIntegrationAuthenticator implements IntegrationAuthenticator {

    @Override
    public void prepare(IntegrationAuthenticationEntity entity) {

    }

    @Override
    public void complete(IntegrationAuthenticationEntity entity) {

    }

}
