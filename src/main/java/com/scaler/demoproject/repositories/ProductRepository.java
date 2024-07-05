package com.scaler.demoproject.repositories;

import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.repositories.projections.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    //insert into product values
    Product findByTitle(String title);
    // select * from product where title = {}
    Product findByDescription(String description);

    Page<Product> findAll(Pageable pageable);

    //How to implement HQL
    @Query("select p from Product p where p.category.id = :categoryId")
    List<Product> getProductsByCategoryId(@Param("categoryId") Long CategoryId);

    //How to implement Native Queries
    @Query(value = "select * from product p where p.category_id = :categoryId", nativeQuery = true)
    List<Product> getProductsByCategoryIdWithNativeQuery(@Param("categoryId") Long CategoryId);

    //HQL with Projections
    //Allows us to fetch certain specific columns from the database
    @Query("select p.title as title, p.id as id from Product p where p.category.id = :categoryId")
    List<ProductProjection> getProductsByCategoryIdProjection(@Param("categoryId") Long CategoryId);
}
