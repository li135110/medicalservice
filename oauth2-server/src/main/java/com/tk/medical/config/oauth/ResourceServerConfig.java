package com.tk.medical.config.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * 资源认证服务
 */

@Configuration
@EnableResourceServer
@Order(3)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, oauthException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .requestMatchers().antMatchers("/java/**")
                .and()
                .authorizeRequests()
                .antMatchers("/java/**").authenticated()
                .and()
                .httpBasic();
    }

}
