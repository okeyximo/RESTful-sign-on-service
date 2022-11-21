package com.example.systemspecstask.controllers;

import com.example.systemspecstask.model.User;
import com.example.systemspecstask.repository.UserRespository;
import com.example.systemspecstask.usecase.payload.request.UserProfileRequest;
import com.example.systemspecstask.usecase.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;
    private User user;

    @BeforeEach
    void setUp() {
        UserProfileRequest userProfileRequest = new UserProfileRequest("Decagon", "xcellnximo57@gmail.com",
                "7 asajon way sangotodo", "@123ABCabc" , "IT","08065788379", "0025582649");
        userService.registerUser(userProfileRequest);
    }

    @Test
    @Disabled
    void generateToken() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/login/")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "    \"email\" : \"xcellnximo57@gmail\",\n" +
                        "    \"password\" : \"@123ABCabc\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }
}