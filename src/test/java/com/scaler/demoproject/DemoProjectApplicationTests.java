package com.scaler.demoproject;

import com.scaler.demoproject.model.Category;
import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.repositories.CategoryRepository;
import com.scaler.demoproject.repositories.ProductRepository;
import com.scaler.demoproject.repositories.projections.ProductProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoProjectApplicationTests {

//    @Autowired
//    private ProductRepository productRepository;
//    @Autowired
//    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    void testingQueries() {
////        List<Product> products = productRepository.getProductsByCategoryId(1L);
////        System.out.println(products.get(0));
//
////        List<Product> products = productRepository.getProductsByCategoryIdWithNativeQuery(1L);
////        System.out.println(products.get(0));
//
//        List<ProductProjection> products = productRepository.getProductsByCategoryIdProjection(1L);
//        System.out.println(products.get(0).getId());
//    }

//    @Test
//    void fetchCategoryLazy() {
//        Category category = categoryRepository.findById(1L).get();
//        System.out.println(category.getId());
//        System.out.println("We are done here");
//
//        List<Product> currentProducts = category.getProducts();
//        //It is going to execute a new query to fetch the list of products
//        System.out.println(currentProducts.size());
//        System.out.println("Products Fetched");
//    }

}
