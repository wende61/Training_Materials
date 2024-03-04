package com.starter.springstarter.service.Impl;

import org.springframework.stereotype.Service;

import com.starter.springstarter.dto.Greeting;
import com.starter.springstarter.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

    private static final String template = "Hello, %s";

    @Override
    public Greeting getGreeting(String name) {
        return new Greeting(1, String.format(template, name));
    }
    
}
