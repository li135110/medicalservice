package com.tk.medical;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EureakServer1Application {
    public static void main(String[] args) {
        SpringApplication.run(EureakServer1Application.class, args);
    }
}
