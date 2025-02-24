package com.pos_system.itp.service;


import com.pos_system.itp.entity.User;

public interface UserService {
    public User userSignUp(User user);
    public boolean userLogin(String email, String password);
}
