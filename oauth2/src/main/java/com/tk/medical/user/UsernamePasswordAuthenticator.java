package com.tk.medical.user;

import com.tk.medical.bean.IntegrationAuthenticationEntity;
import com.tk.medical.bean.UserPojo;
import com.tk.medical.common.AbstractPreparableIntegrationAuthenticator;
import com.tk.medical.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Primary
public class UsernamePasswordAuthenticator extends AbstractPreparableIntegrationAuthenticator {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserPojo authenticate(IntegrationAuthenticationEntity entity) {
        String name = entity.getAuthParameter("name");
        String pwd = entity.getAuthParameter("pwd");
        if(name == null || pwd == null){
            throw new OAuth2Exception("用户名或密码不能为空");
        }

        UserPojo user  = userMapper.selectByUsername(name);
        if (passwordEncoder.matches(pwd,user.getPasword())){
            return user;
        }
        return null;
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return StringUtils.isEmpty(entity.getAuthType());
    }
}
