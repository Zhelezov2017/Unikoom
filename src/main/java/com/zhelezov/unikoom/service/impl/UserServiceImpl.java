package com.zhelezov.unikoom.service.impl;

import com.zhelezov.unikoom.data.entity.User;
import com.zhelezov.unikoom.exception.ResourceNotFoundException;
import com.zhelezov.unikoom.repo.UserRepository;
import com.zhelezov.unikoom.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
