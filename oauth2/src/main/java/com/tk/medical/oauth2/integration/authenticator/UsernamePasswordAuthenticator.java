package com.tk.medical.oauth2.integration.authenticator;

import com.tk.medical.oauth2.integration.IntegrationAuthenticationEntity;
import com.tk.medical.oauth2.mapper.UserMapper;
import com.tk.medical.oauth2.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: yugu
 * @CreateDate: 2018/9/27$ 上午8:31$
 * @Description: 普通认证器（用户名+密码）
 */
@Component
@Primary
public class UsernamePasswordAuthenticator extends AbstractPreparableIntegrationAuthenticator {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserPojo authenticate(IntegrationAuthenticationEntity entity) {
        String name = entity.getAuthParameter("name");
        String pwd = entity.getAuthParameter("pwd");
        if(name == null || pwd == null){
            throw new OAuth2Exception("用户名或密码不能为空");
        }
        UserPojo pojo = mapper.findByName(name);
        if(passwordEncoder.matches(pwd,pojo.getPwd())){
            return pojo;
        }
        return null;
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return StringUtils.isEmpty(entity.getAuthType());
    }
}
