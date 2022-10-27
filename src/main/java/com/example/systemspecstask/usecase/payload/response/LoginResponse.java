package com.example.systemspecstask.usecase.payload.response;

public record LoginResponse(String token, Long id, String companyName, String email, String phoneNumber, String businessType) {
}
