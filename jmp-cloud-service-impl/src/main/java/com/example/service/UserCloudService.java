package com.example.service;

import com.example.User;
import com.example.UserRequestDto;
import com.example.UserResponseDto;
import com.example.UserService;
import com.example.repository.UserRepository;
import com.example.repository.UserRequestDtoToUserConverter;
import com.example.repository.UserToUserResponseDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCloudService implements UserService {
    @Autowired
    private UserToUserResponseDtoConverter toDtoConverter;
    @Autowired
    private UserRequestDtoToUserConverter toUserConverter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUser() {
        return userRepository.findAll().stream()
                        .map(user -> toDtoConverter.convert(user))
                        .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        return toDtoConverter.convert(user);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userDto) {
        User user = toUserConverter.convert(userDto);
        userRepository.save(user);
        return toDtoConverter.convert(user);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userDto) {
        User existingUser = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userDto.getId()));

        existingUser.setName(userDto.getName());
        existingUser.setSurname(userDto.getSurname());
        existingUser.setBirthday(LocalDate.parse(userDto.getBirthday()));

        User updatedUser = userRepository.save(existingUser);

        return toDtoConverter.convert(updatedUser);

    }

    @Override
    public Boolean deleteUser(long userId) {
        try {
            userRepository.deleteById(userId);
            return true;
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
    }
}
