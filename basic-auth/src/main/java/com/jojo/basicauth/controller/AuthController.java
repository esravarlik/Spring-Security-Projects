package com.jojo.basicauth.controller;

import com.jojo.basicauth.model.User;
import com.jojo.basicauth.responses.UserResponse;
import com.jojo.basicauth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/public")
    public String publicGet() {
        return "Hello -public-";
    }

    @GetMapping(value = "/user")
    public String user() {
        return "Role: user";
    }

    @GetMapping(value = "/admin")
    public String admin() {
        return "Role: admin";
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserResponse> create(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.create(user));
    }
}
