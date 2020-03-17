package com.tk.medical.oauth.service;

import com.tk.medical.oauth.bean.IntegrationAuthenticationEntity;
import com.tk.medical.oauth.bean.UserPojo;
import com.tk.medical.oauth.filter.IntegrationAuthenticationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import java.util.List;

public class IntegrationUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private List<IntegrationAuthenticator> authenticators;

    @Autowired(required = false)
    public void setIntegrationAuthenticators(List<IntegrationAuthenticator> authenticators) {
        this.authenticators = authenticators;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        IntegrationAuthenticationEntity entity = IntegrationAuthenticationContext.get();

        if (null == entity) {
            entity = new IntegrationAuthenticationEntity();
        }

        UserPojo userBean = this.authenticate(entity);
        if (null == userBean) {
            throw new OAuth2Exception("此账号不存在！");
        }
        User user = new User(
                userBean.getUsername(),
                passwordEncoder.encode(entity.getAuthParameter("password")), AuthorityUtils.commaSeparatedStringToAuthorityList("ROOT_USER")
        );

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
