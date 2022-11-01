package com.example.systemspecstask.usecase.service.ServiceImpl;

import com.example.systemspecstask.repository.UserRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRespository userRespository;

    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        
    }

    @Test
    @Disabled
    void registerUser() {
    }


    @Test
    @Disabled
    void updateUser() {
    }
}