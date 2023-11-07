package com.example;

import java.util.List;

public interface SubscriptionService {
    List<SubscriptionResponseDto> getAllSubscription();
    SubscriptionResponseDto getSubscriptionById(long subscriptionId);
    SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto);
    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto);
    Boolean deleteSubscription(long subscription);
}
