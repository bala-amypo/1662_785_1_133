package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequestDto dto) {
        return "registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestDto dto) {
        return "token";
    }
}
