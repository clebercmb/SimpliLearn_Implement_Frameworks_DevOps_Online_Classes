package com.example.lesson_02_wiring_beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SimpleLogic implements InitializingBean {


    public SimpleLogic() {
        System.out.println("Class was created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class was initialized");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Class was initialized in afterPropertiesSet");
    }

    @PreDestroy
    public void destroyed() {
        System.out.println("Bean is about to be destroyed");
    }

    public void doSimpleWork() {
        System.out.println("Work from SimpleLogic");
    }
}
