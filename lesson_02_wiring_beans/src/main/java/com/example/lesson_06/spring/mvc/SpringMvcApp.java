package com.example.lesson_06.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringMvcApp.class);
        app.run(args);
    }
}
