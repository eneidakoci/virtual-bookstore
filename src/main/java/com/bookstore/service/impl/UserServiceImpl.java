package com.bookstore.service.impl;

import com.bookstore.domain.dto.UserDto;
import com.bookstore.domain.dto.UserRequest;
import com.bookstore.domain.entity.UserEntity;
import com.bookstore.domain.mapper.UserMapper;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserRequest request) {
        UserEntity userEntity = UserMapper.userRequestToEntity(request);
        userEntity = userRepository.save(userEntity);
        return UserMapper.toDto(userEntity);
    }

    @Override
    public UserDto updateUser(Long id, UserRequest request) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        existingUser.setUsername(request.getUsername());
        existingUser.setEmail(request.getEmail());
        UserEntity updatedUser = userRepository.save(existingUser);
        return UserMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return UserMapper.toDto(userEntity);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(UserMapper::toDto)
                .toList();
    }
}
