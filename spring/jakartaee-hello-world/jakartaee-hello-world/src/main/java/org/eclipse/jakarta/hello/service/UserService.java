package org.eclipse.jakarta.hello.service;

import java.util.List;

import org.eclipse.jakarta.hello.model.User;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface UserService {
    @WebMethod
    List<User> getAllUsers();
    @WebMethod
    User addUser(User entity);
}
