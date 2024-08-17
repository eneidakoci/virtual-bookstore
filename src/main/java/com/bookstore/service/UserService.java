package com.bookstore.service;

import com.bookstore.domain.dto.UserDto;
import com.bookstore.domain.dto.UserRequest;

import java.util.List;

public interface UserService {
    UserDto createUser(UserRequest request);
    UserDto updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
}
