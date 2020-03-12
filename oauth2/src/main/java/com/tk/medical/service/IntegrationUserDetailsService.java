package com.tk.medical.service;

import com.tk.medical.bean.IntegrationAuthenticationEntity;
import com.tk.medical.filter.IntegrationAuthenticationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
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



        return null;
    }
}
