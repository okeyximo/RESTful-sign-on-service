package com.example.systemspecstask.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AuthControllerTest {
@Autowired
   private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateToken() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/login/")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "    \"email\" : \"g@gmail\",\n" +
                        "    \"password\" : \"1234\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isAccepted());

    }
}