package com.tk.medical;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OAuth2Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(OAuth2Application.class, args);
    }
}