package com.scaler.demoproject.service;

import com.scaler.demoproject.dto.FakeStoreProductDto;
import com.scaler.demoproject.exceptions.ProductNotFoundException;
import com.scaler.demoproject.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found with id " + productId);
        }

//        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.getForEntity(
//                "https://fakestoreapi.com/products/" + productId,
//                FakeStoreProductDto.class
//        );
//
//        if(fakeStoreProductDto.getStatusCode() == HttpStatus.NOT_FOUND) {
//            throw new ProductNotFoundException("Product not found with id " + productId);
//        }
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Page<Product> getAllProducts(int pageSize,int pageNumber) {
//        List<Product> products = new ArrayList<>();
//        FakeStoreProductDto[] res = restTemplate.getForObject(
//                "https://fakestoreapi.com/products",
//                FakeStoreProductDto[].class
//        );
//
//        for(FakeStoreProductDto product : res) {
//            products.add(product.toProduct());
//        }
//        return products;
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fs = new FakeStoreProductDto();
        fs.setId(product.getId());
        fs.setTitle(product.getTitle());
        fs.setDescription(product.getDescription());
        fs.setPrice(product.getPrice());
        fs.setCategory(product.getCategory().getTitle());
        fs.setImage(product.getImageUrl());

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fs,
                FakeStoreProductDto.class
        );

        return response.toProduct();

    }
}
