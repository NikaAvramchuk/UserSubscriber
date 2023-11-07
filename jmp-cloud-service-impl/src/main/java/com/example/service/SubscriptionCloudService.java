package com.example.service;

import com.example.Subscription;
import com.example.SubscriptionRequestDto;
import com.example.SubscriptionResponseDto;
import com.example.SubscriptionService;
import com.example.User;
import com.example.repository.SubscriptionRepository;
import com.example.repository.SubscriptionRequestToSubscription;
import com.example.repository.SubscriptionToSubscriptionResponseDTO;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionCloudService implements SubscriptionService {
    @Autowired
    private SubscriptionRepository repository;
    private UserRepository userRepository;
    @Autowired
    private SubscriptionRequestToSubscription toSubscription;
    private SubscriptionToSubscriptionResponseDTO toDto;

    @Override
    public List<SubscriptionResponseDto> getAllSubscription() {
        return repository.findAll().stream()
                .map(subscription -> toDto.convert(subscription))
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionResponseDto getSubscriptionById(long subscriptionId) {
        Subscription subscription = repository.findById(subscriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found with id: " + subscriptionId));
        return toDto.convert(subscription);
    }

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto) {
        Subscription subscription = toSubscription.convert(requestDto);
        repository.save(subscription);
        return toDto.convert(subscription);
    }

    @Override
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto) {
        Subscription existingSubscription = repository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found with id: " + requestDto.getId()));
        final User userFromDb = userRepository.findById(existingSubscription.getUser().getId()).orElseThrow();
        existingSubscription.setUser(userFromDb);

        Subscription updatedSubscription = repository.save(existingSubscription);
        return toDto.convert(updatedSubscription);
    }

    @Override
    public Boolean deleteSubscription(long subscription) {
        try {
            repository.deleteById(subscription);
            return true;
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
    }
}
