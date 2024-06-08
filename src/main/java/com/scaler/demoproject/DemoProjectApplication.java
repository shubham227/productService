package com.scaler.demoproject;

import com.scaler.demoproject.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProjectApplication {

    public static void main(String[] args) {
        Product p = new Product();

        SpringApplication.run(DemoProjectApplication.class, args);
    }
}
