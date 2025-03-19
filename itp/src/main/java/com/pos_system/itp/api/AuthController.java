package com.pos_system.itp.api;


import com.pos_system.itp.dto.request.UserRequestDto;
import com.pos_system.itp.dto.response.UserResponseDto;
import com.pos_system.itp.entity.User;
import com.pos_system.itp.repository.UserRepository;
import com.pos_system.itp.service.UserService;
import com.pos_system.itp.util.StandardResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    private UserService userService;

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<StandardResponseDto>
    create(

            @RequestBody UserRequestDto dto){
        userService.userSignUp(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        201,"user has been saved!",null
                ),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/signin")
    public ResponseEntity<StandardResponseDto> signin(@RequestBody UserRequestDto user) {
        try {

            userService.userLogin(user.getEmail(), user.getPassword());

            return new ResponseEntity<>(
                    new StandardResponseDto(200, "User logged in successfully", null),
                    HttpStatus.OK
            );
        } catch (Exception e) {

            return new ResponseEntity<>(
                    new StandardResponseDto(401, "Login failed: " + e.getMessage(), null),
                    HttpStatus.UNAUTHORIZED
            );
        }
    }
    @GetMapping("/{email}")
    public ResponseEntity<StandardResponseDto> userData(@PathVariable String email) {
        UserResponseDto userData = userService.userData(email);
        return new ResponseEntity<>(
                new StandardResponseDto(200,"User Data",userData),
                HttpStatus.OK
        );
    }
}