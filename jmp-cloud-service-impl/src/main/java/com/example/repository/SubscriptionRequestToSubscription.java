package com.example.repository;

import com.example.Subscription;
import com.example.SubscriptionRequestDto;
import com.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionRequestToSubscription implements Converter<SubscriptionRequestDto, Subscription> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Subscription convert(SubscriptionRequestDto source) {
        Subscription subscription = new Subscription();
        subscription.setId(source.getId());

        User user = userRepository.findById(source.getUserId()).orElseThrow();
        subscription.setUser(user);

        return subscription;
    }
}
