package com.example.systemspecstask.usecase.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileRequest {
    @Pattern(regexp = "^[A-Za-z|\\s]*$",message = "Invalid name")
    private String companyName;

    @Pattern(regexp = "^\\d[A-Za-z|\\s]*$",message = "Invalid address")
    private String address;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",
            message = "Minimum six characters, at least one letter and one number")
    private String password;

    @Pattern(regexp = "^[A-Za-z|\\s]*$",message = "Invalid Business type")
    private String businessType;

    @NotBlank
    private String accountNumber;
}
