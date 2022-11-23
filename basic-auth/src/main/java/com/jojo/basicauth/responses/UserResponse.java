package com.jojo.basicauth.responses;

import com.jojo.basicauth.model.Role;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String email;
    private Role role;
}
