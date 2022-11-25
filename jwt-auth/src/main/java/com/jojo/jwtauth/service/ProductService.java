package com.jojo.jwtauth.service;

import com.jojo.jwtauth.model.Product;
import com.jojo.jwtauth.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product getByProductName(String productName) {
        return this.productRepository.getByProductName(productName);
    }

    public Product create(Product product) {
        return this.productRepository.save(product);
    }


}
