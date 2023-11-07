package com.example.controller;

import com.example.SubscriptionController;
import com.example.SubscriptionRequestDto;
import com.example.SubscriptionResponseDto;
import com.example.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionCloudController implements SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @Override
    @GetMapping
    public List<SubscriptionResponseDto> getAllSubscription() {
        return subscriptionService.getAllSubscription();
    }

    @Override
    @GetMapping("{id}")
    public SubscriptionResponseDto getSubscriptionById(@PathVariable long subscriptionId) {
        return subscriptionService.getSubscriptionById(subscriptionId);
    }

    @Override
    @PostMapping
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto requestDto) {
        return subscriptionService.createSubscription(requestDto);
    }

    @Override
    @PutMapping
    public SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto requestDto) {
        return subscriptionService.updateSubscription(requestDto);
    }

    @Override
    @DeleteMapping("{id}")
    public Boolean deleteSubscription(@PathVariable long subscription) {
        return subscriptionService.deleteSubscription(subscription);
    }
}
