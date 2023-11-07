package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionRequestDto {
    private Long id;
    private Long userId;
}
