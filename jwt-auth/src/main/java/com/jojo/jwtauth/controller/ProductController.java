package com.jojo.jwtauth.controller;

import com.jojo.jwtauth.model.Product;
import com.jojo.jwtauth.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/getByProductName/{productName}")
    public Product getByProductName(@PathVariable("productName") String productName) {
        return this.productService.getByProductName(productName);
    }

    //@PreAuthorize("hasAuthority('ADMIN')")


}