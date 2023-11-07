package com.example.controller;

import com.example.UserController;
import com.example.UserRequestDto;
import com.example.UserResponseDto;
import com.example.service.UserCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/users")
public class UserCloudController implements UserController {
    @Autowired
    private UserCloudService userService;

    @Override
    @GetMapping
    public List<UserResponseDto> getAllUser() {
        return userService.getAllUser();
    }

    @Override
    @GetMapping("{id}")
    public UserResponseDto getUserById(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @Override
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    @PutMapping
    public UserResponseDto updateUser(@RequestBody UserRequestDto userDto) {
        return userService.updateUser(userDto);
    }

    @Override
    @DeleteMapping("{id}")
    public Boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }
}
