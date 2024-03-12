package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;

@RestController
public class DemoController {
    
    
    private DemoService demoService;
    
    @Autowired
    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @RequestMapping(path = "/api", method = RequestMethod.GET)
    public String get(){
        return demoService.greeting();
    }
}
