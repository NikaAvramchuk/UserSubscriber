package com.example;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUser();
    UserResponseDto getUserById(long userId);
    UserResponseDto createUser(UserRequestDto userDto);
    UserResponseDto updateUser(UserRequestDto userDto);
    Boolean deleteUser(long userId);
}
