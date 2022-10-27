package com.example.systemspecstask.controllers;

import com.example.systemspecstask.exceptions.ResourceNotFoundException;
import com.example.systemspecstask.usecase.payload.response.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> AuthenticationFailedExceptionHandler(ResourceNotFoundException ex) {
        return new ResponseEntity<>(new ApiResponse<>("failed", LocalDateTime.now(), ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> DataIntegrityViolationExceptionHandler(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(new ApiResponse<>("failed, Invalid Input", LocalDateTime.now(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
