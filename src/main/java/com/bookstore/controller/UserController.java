package com.bookstore.controller;

import com.bookstore.domain.dto.UserDto;
import com.bookstore.domain.dto.UserRequest;
import com.bookstore.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        if (userDtos == null) {
            throw new EntityNotFoundException("Users not found.");
        }
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long userId) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest userRequest) {
        UserDto createdUser = userService.createUser(userRequest);
        if (createdUser != null) {
            URI locationOfCreatedUser = URI.create("/api/users/" + createdUser.getId());
            return ResponseEntity.created(locationOfCreatedUser).body(createdUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId,
                                              @RequestBody UserRequest userRequest) {
        UserDto updatedUser = userService.updateUser(userId, userRequest);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
