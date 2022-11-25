package com.jojo.jwtauth.config;

import com.jojo.jwtauth.model.Product;
import com.jojo.jwtauth.model.Role;
import com.jojo.jwtauth.model.User;
import com.jojo.jwtauth.service.ProductService;
import com.jojo.jwtauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateEntityConfig implements CommandLineRunner {

    private final UserService userService;

    private final ProductService productService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CreateEntityConfig(UserService userService,
                              ProductService productService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.productService = productService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.create(new User(null, "alp", bCryptPasswordEncoder.encode("pass"), Role.ADMIN));
        userService.create(new User(null, "alperen", bCryptPasswordEncoder.encode("pass"), Role.USER));
        productService.create(new Product(null, "HatayDurum", 45.0, (short) 50));
        productService.create(new Product(null, "Ayran", 4.0, (short) 50));

    }
}


