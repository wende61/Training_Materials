package com.starter.springstarter.service.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.springstarter.dto.user.UserRequestDto;
import com.starter.springstarter.dto.user.UserResponseDto;
import com.starter.springstarter.model.User;
import com.starter.springstarter.repository.UserRepository;
import com.starter.springstarter.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        UserResponseDto response = modelMapper.map(userRepository.save(user), UserResponseDto.class);
        return response;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        TypeToken<List<UserResponseDto>> typeToken = new TypeToken<List<UserResponseDto>>() {
        };
        List<UserResponseDto> response = modelMapper.map(users, typeToken.getType());
        return response;
    }

    @Override
    public Optional<UserResponseDto> getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return Optional.of(new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        ));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, Long id) {
            // Ensure the entity with the same id exists before updating
            User existingUser = userRepository.findById(id).orElseThrow();
            // Update appropriate fields
            existingUser.setName(userRequestDto.getName());
            existingUser.setEmail(userRequestDto.getEmail());
            existingUser.setLastModifiedDate(LocalDateTime.now());
            UserResponseDto response = modelMapper.map(userRepository.save(existingUser), UserResponseDto.class);
            return response;

    }

}
