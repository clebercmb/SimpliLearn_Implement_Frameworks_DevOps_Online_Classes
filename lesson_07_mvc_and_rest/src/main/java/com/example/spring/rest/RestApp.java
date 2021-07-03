package com.example.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RestApp.class);
        app.run(args);
    }
}
