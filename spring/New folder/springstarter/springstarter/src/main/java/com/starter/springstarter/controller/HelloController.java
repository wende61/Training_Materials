package com.starter.springstarter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.starter.springstarter.dto.Hello;
import com.starter.springstarter.model.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class HelloController {
    
    @RequestMapping(path = "/hello", method=RequestMethod.GET)
    public Hello hello(@RequestParam(required = false) String name) {
        return new Hello(1,name);
    }
    
    @RequestMapping("/user")
    @ResponseBody
    private User getUser() {
        String uri = "https://jsonplaceholder.typicode.com/users/1";
        RestTemplate restTemplate = new RestTemplate();

        User user = restTemplate.getForObject(uri, User.class);
        System.out.println("User: " + user);

        return user;
    }

}
