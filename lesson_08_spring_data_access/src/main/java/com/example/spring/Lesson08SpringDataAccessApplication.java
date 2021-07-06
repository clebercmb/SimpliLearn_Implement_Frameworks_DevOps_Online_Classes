package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson08SpringDataAccessApplication {

    public static void main(String[] args) {

        //SpringApplication.run(Lesson08SpringDataAccessApplication.class, args);
        SpringApplication app = new SpringApplication(Lesson08SpringDataAccessApplication.class);
        app.run(args);
    }

}
