package com.tk.medical.oauth.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * 认证实体
 */
@Getter
@Setter
@ToString
public class IntegrationAuthenticationEntity {
    //请求登录认证类型
    private String authType;

    //请求登录认证参数的集合
    private Map<String, String[]> authParameters;


    public String getAuthParameter(String parameter) {
        String[] parameters = this.authParameters.get(parameter);
        if (null != parameters && parameters.length > 0) {
            return parameters[0];
        }
        return null;
    }

}
