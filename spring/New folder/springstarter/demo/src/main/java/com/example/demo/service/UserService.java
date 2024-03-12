package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
     List<User> getUsers();
     User createUser(User user);
}
