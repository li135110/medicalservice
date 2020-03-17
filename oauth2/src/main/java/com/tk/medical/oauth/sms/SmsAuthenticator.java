package com.tk.medical.oauth.sms;

import com.tk.medical.oauth.bean.IntegrationAuthenticationEntity;
import com.tk.medical.oauth.bean.UserPojo;
import com.tk.medical.oauth.common.AbstractPreparableIntegrationAuthenticator;
import com.tk.medical.oauth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 短信认证
 */
@Component
public class SmsAuthenticator extends AbstractPreparableIntegrationAuthenticator {


    private final static String AUTH_TYPE = "sms";

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserPojo authenticate(IntegrationAuthenticationEntity entity) {
        String mobile = entity.getAuthParameter("mobile");
        if (StringUtils.isEmpty(mobile)){
            throw new OAuth2Exception("null nobile");
        }
        String code = entity.getAuthParameter("code");
        if (!"12".equals(code)){
            throw new OAuth2Exception("err code");
        }
        return userMapper.selectByMobile(mobile);
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return AUTH_TYPE.equals(entity.getAuthType());
    }
}