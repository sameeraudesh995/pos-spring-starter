package com.pos_system.itp.service;


import com.pos_system.itp.dto.request.UserRequestDto;
import com.pos_system.itp.dto.response.UserResponseDto;
import com.pos_system.itp.entity.User;

public interface UserService {
    public void userSignUp(UserRequestDto user);
    public boolean userLogin(String email, String password);
    public UserResponseDto userData(String email);
}
