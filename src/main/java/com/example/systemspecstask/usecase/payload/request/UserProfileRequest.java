package com.example.systemspecstask.usecase.payload.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserProfileRequest {

    @Pattern(regexp = "^[A-Za-z|\\s]*$",message = "Invalid name")
    private String companyName;

    @Pattern(regexp = "^[A-Za-z|\\s]*$",message = "Invalid Email")
    private String email;

    @Pattern(regexp = "^[A-Za-z|\\s]*$",message = "Invalid Business name")

    private String address;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",
            message = "Minimum six characters, at least one letter and one number")
    private String password;

    @Pattern(regexp = "^[A-Za-z|\\s]*$",message = "Invalid Business name")
    private String businessType;

    @Pattern(regexp = "((^(234){1}[0–9]{10})|((^234)[0–9]{10})|((^0)(7|8|9){1}(0|1){1}[0–9]{8}))")
    private String phoneNumber;

    @NotBlank
    private String accountNumber;

}
