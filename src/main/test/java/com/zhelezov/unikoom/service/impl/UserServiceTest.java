package com.zhelezov.unikoom.service.impl;


import com.zhelezov.unikoom.data.entity.User;
import com.zhelezov.unikoom.repo.UserRepository;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void getAll() {
        when(userRepository.findAll()).thenReturn(getUsers());
        List<User> users = userService.getAll();

        Assert.assertEquals(getUsers(), users);
    }

    @Test
    void getById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(getUser()));

        User user = userService.getById(1L);

        Assert.assertEquals(getUser(), user);
    }

    @Test
    void save() {
        when(userRepository.save(getUser())).thenReturn(getUser());

        User user = userService.save(getUser());

        Assert.assertEquals(getUser(), user);
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User userVlad = new User();
        userVlad.setId(1L);
        userVlad.setUsername("Vlad");

        User userAnton = new User();
        userAnton.setId(2L);
        userAnton.setUsername("Anton");

        users.add(userVlad);
        users.add(userAnton);
        return users;
    }

    private User getUser() {
        User userVlad = new User();
        userVlad.setId(1L);
        userVlad.setUsername("Vlad");
        userVlad.setDateOfBirth(LocalDate.of(2010, 1, 2));

        return userVlad;
    }
}