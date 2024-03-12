package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String greeting() {
        return "Hello from Service";
    }
    
}
