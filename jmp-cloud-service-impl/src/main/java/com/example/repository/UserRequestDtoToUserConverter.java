package com.example.repository;

import com.example.User;
import com.example.UserRequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserRequestDtoToUserConverter implements Converter<UserRequestDto, User> {

    @Override
    public User convert(UserRequestDto source) {
        User user = new User();
        user.setName(source.getName());
        user.setSurname(source.getSurname());

        // Convert String to LocalDate
        if (source.getBirthday() != null && !source.getBirthday().isEmpty()) {
            user.setBirthday(LocalDate.parse(source.getBirthday()));
        }
        return user;
    }
}
