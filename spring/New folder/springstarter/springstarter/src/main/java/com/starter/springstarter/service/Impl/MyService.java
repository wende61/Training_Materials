package com.starter.springstarter.service.Impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class MyService implements InitializingBean {

    public MyService() {
        System.out.println("Constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Init method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean's afterPropertiesSet method called");
    }

    // Other methods...

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy method called");
    }
}

