package com.zhelezov.unikoom.rest;

import com.zhelezov.unikoom.data.entity.User;
import com.zhelezov.unikoom.rest.dto.UserDto;
import com.zhelezov.unikoom.rest.dto.UserShortDto;
import com.zhelezov.unikoom.rest.mapper.UserMapper;
import com.zhelezov.unikoom.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserShortDto> getAllUsers() {
        return userService.getAll().stream()
                .map(userMapper::toUserShortDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable("id") Long userId) {
        return userMapper.toDto(userService.getById(userId));
    }

    @PostMapping
    public UserDto saveUser(@Valid @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User saved = userService.save(user);
        return userMapper.toDto(saved);
    }

}
