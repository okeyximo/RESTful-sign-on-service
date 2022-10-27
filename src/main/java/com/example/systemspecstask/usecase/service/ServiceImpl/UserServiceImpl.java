package com.example.systemspecstask.usecase.service.ServiceImpl;

import com.example.systemspecstask.model.User;
import com.example.systemspecstask.repository.UserRespository;
import com.example.systemspecstask.usecase.payload.request.UpdateProfileRequest;
import com.example.systemspecstask.usecase.payload.request.UserProfileRequest;
import com.example.systemspecstask.usecase.payload.response.ApiResponse;
import com.example.systemspecstask.usecase.payload.response.RegisterationResponse;
import com.example.systemspecstask.usecase.service.UserService;
import com.example.systemspecstask.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRespository userRespository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;


    @Override
    public ApiResponse<?> registerUser(UserProfileRequest userProfileRequest){
        User newUser = modelMapper.map(userProfileRequest, User.class);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRespository.save(newUser);
        RegisterationResponse data = new RegisterationResponse(newUser.getId(), newUser.getCompanyName(), newUser.getPhoneNumber(), newUser.getAddress(), newUser.getEmail(), newUser.getAccountNumber());
        return new ApiResponse<>("success", LocalDateTime.now(), data);
    }

    @Override
    public ApiResponse<?> updateUser(UpdateProfileRequest updateProfileRequest){
        User user = userRespository.findUserByEmail(userUtil.getAuthenticatedUserEmail());
        userRespository.save(userUtil.updateUserMapper(updateProfileRequest, user));
        RegisterationResponse data = new RegisterationResponse(user.getId(), user.getCompanyName(), user.getPhoneNumber(), user.getAddress(), user.getEmail(), user.getAccountNumber());
        return new ApiResponse<>("success", LocalDateTime.now(), data);
    }

}
