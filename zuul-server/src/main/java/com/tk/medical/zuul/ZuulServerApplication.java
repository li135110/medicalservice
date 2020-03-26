package com.tk.medical.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulServerApplication {
    public static void main(String[] args) {
        System.out.println("网关启动...");
        SpringApplication.run(ZuulServerApplication.class,args);
    }
}
