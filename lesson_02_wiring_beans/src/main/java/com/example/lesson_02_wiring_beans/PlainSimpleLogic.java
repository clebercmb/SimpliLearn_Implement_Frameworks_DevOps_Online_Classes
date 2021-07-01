package com.example.lesson_02_wiring_beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



public class PlainSimpleLogic implements InitializingBean {

    @Autowired
    private SimpleLogic simpleLogic;

    public PlainSimpleLogic() {
        System.out.println("PLain Class was created");
    }

    public void init() {
        System.out.println("Plain Class was initialized");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PLain Class was initialized in afterPropertiesSet");
    }

    public void destroyed() {
        System.out.println("PLain Bean is about to be destroyed");
    }

    public void doSomeWork() {
        simpleLogic.doSimpleWork();
    }


}
