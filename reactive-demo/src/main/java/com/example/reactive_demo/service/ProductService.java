package com.example.reactivedemo.service;

import com.example.reactivedemo.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product("1", "Laptop", 999.99),
            new Product("2", "Phone", 499.99),
            new Product("3", "Tablet", 299.99)
    );

    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(products);
    }

    public Mono<Product> getProductById(String id) {
        return Flux.fromIterable(products)
                .filter(p -> p.getId().equals(id))
                .next(); // returns Mono
    }
}
