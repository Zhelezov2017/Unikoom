package com.zhelezov.unikoom.service;

import com.zhelezov.unikoom.data.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    User save(User user);
}
