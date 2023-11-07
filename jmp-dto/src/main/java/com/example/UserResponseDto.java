package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String birthday;
}

