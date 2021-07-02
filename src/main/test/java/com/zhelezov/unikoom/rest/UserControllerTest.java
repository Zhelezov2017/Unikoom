package com.zhelezov.unikoom.rest;

import com.zhelezov.unikoom.data.entity.User;
import com.zhelezov.unikoom.rest.mapper.UserMapper;
import com.zhelezov.unikoom.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.parseMediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockitoSettings
@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = UserController.class)
class UserControllerTest {

    private static final String BASE_URI = "/api/v1/users";
    private static final String USER_BY_ID_URI = BASE_URI + "/1";
    private static final String APPLICATION_JSON_CHARSET = "application/json;charset=UTF-8";

    @MockBean
    private UserService userService;
    @MockBean
    private UserMapper userMapper;
    @Autowired
    private MockMvc mockMvc;
    @Test
    void getAllUsers() throws Exception {
        when(userService.getAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(get(BASE_URI)
                .accept(parseMediaType(APPLICATION_JSON_CHARSET)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getUserById() throws Exception {
        when(userService.getById(1L)).thenReturn(getUser());

        mockMvc.perform(get(USER_BY_ID_URI)
                .accept(parseMediaType(APPLICATION_JSON_CHARSET)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void saveUser() throws Exception {
        when(userService.save(any())).thenReturn(getUser());

        mockMvc.perform(post(BASE_URI)
                .accept(parseMediaType(APPLICATION_JSON_CHARSET)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    private User getUser() {
        User userVlad = new User();
        userVlad.setId(1L);
        userVlad.setUsername("Vlad");
        userVlad.setDateOfBirth(LocalDate.of(2010, 1, 2));

        return userVlad;
    }
}