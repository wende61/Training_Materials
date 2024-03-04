package com.starter.springstarter.service;

import java.util.List;
import java.util.Optional;

import com.starter.springstarter.dto.user.UserRequestDto;
import com.starter.springstarter.dto.user.UserResponseDto;

public interface UserService {
    public UserResponseDto saveUser(UserRequestDto user);
    public List<UserResponseDto> getAllUsers();
    public Optional<UserResponseDto> getUser(Long id);
    public UserResponseDto updateUser(UserRequestDto userRequestDto, Long id);
}
