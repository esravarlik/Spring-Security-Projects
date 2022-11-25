package com.jojo.jwtauth.service;

import com.jojo.jwtauth.dto.TokenResponse;
import com.jojo.jwtauth.exception.GeneralException;
import com.jojo.jwtauth.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;


    public TokenResponse login(UserRequest loginRequest) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return TokenResponse
                    .builder()
                    .accessToken(tokenService.generateToken(auth))
                    .user(userService.getUserDto(loginRequest.getUsername()))
                    .build();
        } catch (final BadCredentialsException badCredentialsException) {
            throw new GeneralException("Invalid Username or Password", HttpStatus.BAD_REQUEST);
        }
    }

}
