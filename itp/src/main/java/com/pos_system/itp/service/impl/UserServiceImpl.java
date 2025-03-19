package com.pos_system.itp.service.impl;


import com.pos_system.itp.dto.request.CustomerRequestDto;
import com.pos_system.itp.dto.request.UserRequestDto;
import com.pos_system.itp.dto.response.UserResponseDto;
import com.pos_system.itp.entity.Customer;
import com.pos_system.itp.entity.User;
import com.pos_system.itp.exception.EntryNotFoundException;
import com.pos_system.itp.repository.UserRepository;
import com.pos_system.itp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public void userSignUp(UserRequestDto user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists with this email");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(toUser(user));
    }

    @Override
    public boolean userLogin(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public UserResponseDto userData(String email) {
        if(email == null) {
            throw new EntryNotFoundException("Email Not Found");
        }
        Optional<User> userOptional = userRepository.findByEmail(email);
        System.out.println(userOptional);
        if(userOptional.isEmpty()) throw new EntryNotFoundException("Email Not Found");
        return userOptional.map(user -> UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build()).orElse(null);

    }

    private User toUser(
            UserRequestDto dto
    ){
        return User.builder()
                .id(
                        UUID.randomUUID().toString())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName()).build();
    }
}

