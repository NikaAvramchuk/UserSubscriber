package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionResponseDto {
    private Long id;
    private Long userId;
    private String startDate;
}
