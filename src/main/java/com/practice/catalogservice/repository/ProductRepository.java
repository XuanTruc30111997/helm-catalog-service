package com.practice.catalogservice.repository;

import com.practice.catalogservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Modifying
    @Query(value = "INSERT INTO product(id, title, price) values (:id, :title, :price)", nativeQuery = true)
    @Transactional
    void insertProduct(@Param("id") String id, @Param("title") String title, @Param("price") Float price);

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    Collection<Product> getAllProduct();

//    @Query(value = "SELECT * FROM product p WHERE p.id = uuid(?1)", nativeQuery = true)
//    Collection<Product> getProductById(String productId);

    @Query(value = "SELECT * FROM product p WHERE p.id = :productId", nativeQuery = true)
    Collection<Product> getProductById(@Param(value = "productId") String productId);
}
