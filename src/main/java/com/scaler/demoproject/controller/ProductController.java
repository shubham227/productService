package com.scaler.demoproject.controller;

import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

// POST /product
//    Request Body
//    {
//        title: 'test product',
//                price: 13.5,
//            description: 'lorem ipsum set',
//            image: 'https://i.pravatar.cc',
//            category: 'electronic'
//    }

    //Dependency Injection using Inversion of Control
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        Product postRequestResponse = productService.createProduct(product);
        return postRequestResponse;
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long productId) {
        Product currentProduct = productService.getSingleProduct(productId);
        return currentProduct;
    }

    @GetMapping("/products")
    public void getAllProducts() {
        productService.getAllProducts();
    }
}
