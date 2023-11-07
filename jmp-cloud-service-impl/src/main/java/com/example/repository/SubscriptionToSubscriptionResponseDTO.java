package com.example.repository;


import com.example.Subscription;
import com.example.SubscriptionResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionToSubscriptionResponseDTO implements Converter<Subscription, SubscriptionResponseDto> {

    @Override
    public SubscriptionResponseDto convert(Subscription source) {
        return new SubscriptionResponseDto(
                source.getId(),
                source.getUser().getId(),
                source.getStartDate().toString());
    }
}



