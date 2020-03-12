package com.tk.medical.common;

import com.tk.medical.bean.IntegrationAuthenticationEntity;
import com.tk.medical.service.IntegrationAuthenticator;

public abstract class AbstractPreparableIntegrationAuthenticator implements IntegrationAuthenticator {

    @Override
    public void prepare(IntegrationAuthenticationEntity entity) {

    }

    @Override
    public void complete(IntegrationAuthenticationEntity entity) {

    }

}
