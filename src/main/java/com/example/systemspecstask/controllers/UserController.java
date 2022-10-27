package com.example.systemspecstask.controllers;

import com.example.systemspecstask.usecase.payload.request.UpdateProfileRequest;
import com.example.systemspecstask.usecase.payload.request.UserProfileRequest;
import com.example.systemspecstask.usecase.payload.response.ApiResponse;
import com.example.systemspecstask.usecase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<ApiResponse<?>> registerUser(@Valid @RequestBody UserProfileRequest userProfileRequest) throws Exception {
        return new ResponseEntity<>(userService.registerUser(userProfileRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping(value = "update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateProfileRequest updateProfileRequest){

        return new ResponseEntity<>(userService.updateUser(updateProfileRequest), HttpStatus.OK);
    }

}
