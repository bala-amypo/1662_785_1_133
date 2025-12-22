package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        if (productRepository.findBySku(product.getSku()).isPresent()) {
            throw new BadRequestException("SKU already exists");
        }
        return productRepository.save(product);
    }

    public Product get(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
