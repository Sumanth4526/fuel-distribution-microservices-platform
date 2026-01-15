package com.hpcl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpcl.entity.User;
import com.hpcl.repository.UserRepository;
import com.hpcl.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User request) {
        System.out.println("Login request received for user: " + request.getUsername());
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Credentials");
        }
        return jwtUtil.generateToken(user.getUsername(), user.getRole().name());
    }

}
