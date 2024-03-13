package org.eclipse.jakarta.hello.service;

import java.util.List;

import org.eclipse.jakarta.hello.model.User;
import org.eclipse.jakarta.hello.repository.UserRepository;

import jakarta.inject.Inject;
import jakarta.jws.WebService;

@WebService(endpointInterface = "org.eclipse.jakarta.hello.service.UserService")
public class UserServiceImpl implements UserService {
    
    @Inject
    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User addUser(User entity) {
        return repository.save(entity);
    }
}
