package com.starter.springstarter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.starter.springstarter.dto.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    
    @RequestMapping(path = "/hello", method=RequestMethod.GET)
    public Hello hello(@RequestParam(required = false) String name) {
        return new Hello(1,name);
    }
    

}
