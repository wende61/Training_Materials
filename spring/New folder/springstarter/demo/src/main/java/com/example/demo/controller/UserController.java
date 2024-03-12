package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path = "/users")
    public User createUsers(User user){
        return userService.createUser(user);
    }

}
