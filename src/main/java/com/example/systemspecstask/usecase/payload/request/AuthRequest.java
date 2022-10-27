package com.example.systemspecstask.usecase.payload.request;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class AuthRequest {

    @Pattern(regexp = "^(.+)@(\\S+)$", message = "Enter a valid email address")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",
            message = "Minimum six characters, at least one letter and one number")
    private String password;
}
