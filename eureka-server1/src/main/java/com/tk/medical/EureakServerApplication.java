package com.tk.medical;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureakServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(EureakServerApplication.class, args);
        System.err.println("注册中心1启动...");
    }
}
