package com.example.lesson_02_wiring_beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson02WiringBeansApplication01 {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Lesson02WiringBeansApplication01.class, args);
        System.out.println(context.getBean(PlainSimpleLogic.class));
        System.out.println(context.getBean(PlainSimpleLogic.class));
        System.out.println(context.getBean(PlainSimpleLogic.class));

        context.getBean(PlainSimpleLogic.class).doSomeWork();
    }

}
