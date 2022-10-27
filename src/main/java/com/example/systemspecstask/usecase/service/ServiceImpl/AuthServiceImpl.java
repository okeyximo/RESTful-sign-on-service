package com.example.systemspecstask.usecase.service.ServiceImpl;

import com.example.systemspecstask.config.security.AuthUserService;
import com.example.systemspecstask.config.security.JwtService;
import com.example.systemspecstask.exceptions.ResourceNotFoundException;
import com.example.systemspecstask.usecase.payload.request.AuthRequest;
import com.example.systemspecstask.exceptions.AuthenticationFailedException;
import com.example.systemspecstask.exceptions.CustomNotFoundException;
import com.example.systemspecstask.model.User;
import com.example.systemspecstask.repository.UserRespository;
import com.example.systemspecstask.usecase.payload.response.ApiResponse;
import com.example.systemspecstask.usecase.payload.response.LoginResponse;
import com.example.systemspecstask.usecase.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private AuthUserService authUserService;

    private final AuthenticationManager authenticationManager;
    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Override
    public ApiResponse<LoginResponse> loginUser(AuthRequest authRequest){
        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (AuthenticationException ex) {
            log.error(ex.getMessage());
            throw new ResourceNotFoundException("Invalid username or password");
        }
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        User appUserEntity = userRespository.findUserByEmail(authRequest.getEmail());
        if(appUserEntity == null){
            throw new CustomNotFoundException("User does not exist");
        }
        String token = "Bearer " + jwtService
                .generateToken(new org.springframework.security.core.userdetails
                        .User(authRequest.getEmail(), authRequest.getPassword(), new ArrayList<>()));
        return new ApiResponse<>("Success", LocalDateTime.now(), new LoginResponse(token, appUserEntity.getId(), appUserEntity.getCompanyName(),
                appUserEntity.getEmail(), appUserEntity.getPhoneNumber(), appUserEntity.getBusinessType()));
    }


}
