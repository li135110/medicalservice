package com.tk.medical.oauth2.integration.authenticator;

import com.tk.medical.oauth2.integration.IntegrationAuthenticationEntity;
import com.tk.medical.oauth2.mapper.UserMapper;
import com.tk.medical.oauth2.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: yugu
 * @CreateDate: 2018/9/27$ 上午9:46$
 * @Description: 短信认证器
 */
@Component
public class SmsAuthenticator extends AbstractPreparableIntegrationAuthenticator {

    private final static String AUTH_TYPE = "sms";
    @Autowired
    private UserMapper mapper;

    @Override
    public UserPojo authenticate(IntegrationAuthenticationEntity entity) {
        String mobile = entity.getAuthParameter("mobile");
        if(StringUtils.isEmpty(mobile)){
            throw new OAuth2Exception("手机号不能为空");
        }
        String code = entity.getAuthParameter("code");
        //测试项目，所以将验证码顶死为：1234
        if(! "1234".equals(code)){
            throw new OAuth2Exception("验证码错误或已过期");
        }
        return mapper.findByMobile(mobile);
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return AUTH_TYPE.equals(entity.getAuthType());
    }
}
