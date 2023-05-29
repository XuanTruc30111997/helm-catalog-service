package com.practice.catalogservice.repository;

import com.practice.catalogservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Modifying
    @Query(value = "INSERT INTO category(id, title) values (:id, :title)", nativeQuery = true)
    @Transactional
    void insertCategory(@Param("id") String id, @Param("title") String title);

    @Query(value = "SELECT * FROM category", nativeQuery = true)
    Collection<Category> getAllCategory();

    @Query(value = "SELECT * FROM category c where c.id = :categoryid", nativeQuery = true)
    Collection<Category> getCategory(@Param(value = "categoryid") String categoryId);
}
