package com.tk.medical.oauth2.integration;

import com.tk.medical.oauth2.integration.authenticator.IntegrationAuthenticator;
import com.tk.medical.oauth2.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: yugu
 * @CreateDate: 2018/9/26$ 下午10:01$
 * @Description: 集成认证-用户细节服务
 */
@Service
public class IntegrationUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private List<IntegrationAuthenticator> authenticators;

    @Autowired(required = false)
    public void setIntegrationAuthenticators(List<IntegrationAuthenticator> authenticators) {
        this.authenticators = authenticators;
    }

    @Override
    public UserDetails loadUserByUsername(String str) throws UsernameNotFoundException {
        IntegrationAuthenticationEntity entity = IntegrationAuthenticationContext.get();
        if (entity == null){
            entity = new IntegrationAuthenticationEntity();
        }
        UserPojo pojo = this.authenticate(entity);
        if (pojo == null){
            throw new OAuth2Exception("此账号不存在！");
        }
        User user = new User(pojo.getName(),passwordEncoder.encode(entity.getAuthParameter("password")), AuthorityUtils.commaSeparatedStringToAuthorityList("ROOT_USER"));
        return user;
    }

    private UserPojo authenticate(IntegrationAuthenticationEntity entity) {
        if (this.authenticators != null) {
            for (IntegrationAuthenticator authenticator : authenticators) {
                if (authenticator.support(entity)) {
                    return authenticator.authenticate(entity);
                }
            }
        }
        throw new OAuth2Exception("无效的auth_type参数值！");
    }
}
