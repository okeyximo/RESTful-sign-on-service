package com.example.systemspecstask.repository;

import com.example.systemspecstask.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class UserRespositoryTest {

    @Autowired
    private UserRespository userRespository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Decagon",
                "08065788379",
                "7 asajon way sangotodo, " +
                        "Lagos",
                "IT",
                "xcellnximo57@gmail.com",
                "0025582649",
                "@123ABCabc");
        userRespository.save(user);
    }

    @Test
    void shouldCheckIfTheUserExist() {
        User actual = userRespository.findUserByEmail("xcellnximo57@gmail.com");
        assertThat(actual).isNotNull();
        assertThat(actual.getPhoneNumber()).isEqualTo("08065788379");
    }

    @Test
    void shouldCheckIfTheUserDoesNotExist() {
        User actual = userRespository.findUserByEmail("okey@gmail.com");
        assertThat(actual).isNull();
    }
}