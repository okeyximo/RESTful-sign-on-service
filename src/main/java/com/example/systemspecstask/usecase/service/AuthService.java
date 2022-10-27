package com.example.systemspecstask.usecase.service;

import com.example.systemspecstask.usecase.payload.response.ApiResponse;
import com.example.systemspecstask.usecase.payload.response.LoginResponse;
import com.example.systemspecstask.usecase.payload.request.AuthRequest;

public interface AuthService {

    ApiResponse<LoginResponse> loginUser(AuthRequest authRequest);
}
