package com.scaler.demoproject.controller;

import com.scaler.demoproject.dto.ErrorDto;
import com.scaler.demoproject.exceptions.ProductNotFoundException;
import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        Product currentProduct = productService.getSingleProduct(productId);
        ResponseEntity<Product> res = new ResponseEntity<>(
                currentProduct, HttpStatus.OK
        );
        return res;
//        return currentProduct;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
