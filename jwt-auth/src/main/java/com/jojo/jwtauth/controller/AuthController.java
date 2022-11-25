package com.jojo.jwtauth.controller;

import com.jojo.jwtauth.dto.TokenResponse;
import com.jojo.jwtauth.request.UserRequest;
import com.jojo.jwtauth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody UserRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Hello -public-";
    }

    @GetMapping("/user")
    public String user() {
        return "Role: User";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Role: Admin";
    }
}



