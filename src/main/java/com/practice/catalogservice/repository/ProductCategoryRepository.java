package com.practice.catalogservice.repository;

import com.practice.catalogservice.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
    @Modifying
    @Query(value = "INSERT INTO product_category(productid, categoryid) values (:productid, :categoryid)", nativeQuery = true)
    @Transactional
    void insertProductCategory(@Param("productid") String productId, @Param("categoryid") String categoryId);

    @Query(value = "SELECT * FROM product_category pc WHERE pc.productid = :productid", nativeQuery = true)
    Collection<ProductCategory> getProductCategoryByProductId(@Param("productid") String productId);

    @Query(value = "SELECT * FROM product_category pc WHERE pc.categoryid = :categoryid", nativeQuery = true)
    Collection<ProductCategory> getProductCategoryByCategory(@Param("categoryid") String categoryId);
}
