package com.example.systemspecstask.controllers;

import com.example.systemspecstask.usecase.payload.request.AuthRequest;
import com.example.systemspecstask.usecase.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
@RestController
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody @Valid AuthRequest authRequest)  {
        return new ResponseEntity<>(authService.loginUser(authRequest), HttpStatus.OK);
    }

}
