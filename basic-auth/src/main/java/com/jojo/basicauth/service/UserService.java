package com.jojo.basicauth.service;

import com.jojo.basicauth.model.User;
import com.jojo.basicauth.repository.UserRepository;
import com.jojo.basicauth.responses.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    public UserResponse create(User user) {
        User toSave = new User();
        toSave.setEmail(user.getEmail());
        toSave.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        toSave.setRole(user.getRole());
        return modelMapper.map(userRepository.save(toSave), UserResponse.class);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found."));
    }

}
