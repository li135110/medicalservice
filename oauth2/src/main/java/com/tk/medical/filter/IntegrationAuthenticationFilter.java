package com.tk.medical.filter;


import com.tk.medical.bean.IntegrationAuthenticationEntity;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import com.tk.medical.service.IntegrationAuthenticator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class IntegrationAuthenticationFilter extends GenericFilterBean implements ApplicationContextAware {

    private static final String AUTH_TYPE_PARM_NAME = "auth_type";//登录类型参数名
    private static final String OAUTH_TOKEN_URL = "/oauth/token";//需要拦截的路由
    private RequestMatcher requestMatcher;
    private ApplicationContext applicationContext;
    private Collection<IntegrationAuthenticator> authenticators;

    public IntegrationAuthenticationFilter() {
        AntPathRequestMatcher get = new AntPathRequestMatcher(OAUTH_TOKEN_URL, "GET");
        AntPathRequestMatcher post = new AntPathRequestMatcher(OAUTH_TOKEN_URL, "POST");
        this.requestMatcher = new OrRequestMatcher(get, post);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (requestMatcher.matches(request)) {
            RequestParameterWrappe requestParameterWrappe = new RequestParameterWrapper();
            if (requestParameterWrapper.getParameter("password") == null) {
                requestParameterWrapper.addParameter("password", "");
            }
            IntegrationAuthenticationEntity entity = new IntegrationAuthenticationEntity();
            entity.setAuthType(requestParameterWrapper.getParameter(AUTH_TYPE_PARM_NAME));
            entity.setAuthParameters(requestParameterWrapper.getParameterMap());
            IntegrationAuthenticationContext.set(entity);
            try {
                this.prepare(entity);
                filterChain.doFilter(requestParameterWrapper, servletResponse);
                this.complete(entity);
            } finally {
                IntegrationAuthenticationContext.clear();
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 认证前回调
     *
     * @param entity 集成认证实体
     */
    private void prepare(IntegrationAuthenticationEntity entity) {
        if (entity != null) {
            synchronized (this) {
                Map<String, IntegrationAuthenticator> map = applicationContext.getBeansOfType(IntegrationAuthenticator.class);
                if (map != null) {
                    this.authenticators = map.values();
                }
            }
        }
        if (this.authenticators == null) {
            this.authenticators = new ArrayList<>();
        }
        for (IntegrationAuthenticator authenticator : this.authenticators) {
            if (authenticator.support(entity)) {
                authenticator.prepare(entity);
            }
        }
    }

    /**
     * 认证结束后回调
     *
     * @param entity 集成认证实体
     */
    private void complete(IntegrationAuthenticationEntity entity) {
        for (IntegrationAuthenticator authenticator : authenticators) {
            if (authenticator.support(entity)) {
                authenticator.complete(entity);
            }
        }
    }


}