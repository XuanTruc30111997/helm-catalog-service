package com.practice.catalogservice.controller;

import com.practice.catalogservice.dto.category.CategoryDTO;
import com.practice.catalogservice.dto.category.CategoryInsert;
import com.practice.catalogservice.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<String> postCategory(@RequestBody CategoryInsert category) {
        String categoryId = categoryService.insertCategory(category);
        return ResponseEntity.ok().body(categoryId);
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryDTO>> getCategories() {
        Collection<CategoryDTO> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }
}
