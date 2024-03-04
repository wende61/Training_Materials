package com.starter.springstarter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.starter.springstarter.dto.Greeting;
import com.starter.springstarter.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService service;

    private static final String template = "Hello, %s";

    @RequestMapping(path = "/greetings", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(name = "name", defaultValue = "world") String name) {
        return new Greeting(0, name);
    }

    @RequestMapping(path = "/greetings", method = RequestMethod.POST)
    public Greeting greeting(@RequestBody Greeting greeting) {
        return new Greeting(2, greeting.getContent());
    }

}
