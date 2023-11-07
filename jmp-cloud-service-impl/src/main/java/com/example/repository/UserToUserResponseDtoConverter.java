package com.example.repository;

import com.example.User;
import com.example.UserResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResponseDtoConverter implements Converter<User, UserResponseDto> {

    @Override
    public UserResponseDto convert(User source) {
        return new UserResponseDto(source.getId(),
                source.getName(),
                source.getSurname(),
                source.getBirthday().toString());
    }
}
