package com.example.systemspecstask.usecase.service;

import com.example.systemspecstask.usecase.payload.request.UpdateProfileRequest;
import com.example.systemspecstask.usecase.payload.request.UserProfileRequest;
import com.example.systemspecstask.usecase.payload.response.ApiResponse;

public interface UserService {

    ApiResponse<?> registerUser(UserProfileRequest userProfileRequest);

    ApiResponse<?> updateUser(UpdateProfileRequest updateProfileRequest);
}
