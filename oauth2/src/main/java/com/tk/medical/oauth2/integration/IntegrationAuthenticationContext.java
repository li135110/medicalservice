package com.tk.medical.oauth2.integration;

/**
 * @Author: yugu
 * @CreateDate: 2018/9/26
 * @Description: 集成认证上下文
 */

public class IntegrationAuthenticationContext {
    private static ThreadLocal<IntegrationAuthenticationEntity> holder = new ThreadLocal<>();

    public static void set(IntegrationAuthenticationEntity entity){
        holder.set(entity);
    }

    public static IntegrationAuthenticationEntity get(){
        return holder.get();
    }

    public static void clear(){
        holder.remove();
    }
}
