package com.practice.catalogservice.controller;


import com.practice.catalogservice.dto.categoryDetails.ProductDetailInsert;
import com.practice.catalogservice.dto.categoryDetails.ProductDetails;
import com.practice.catalogservice.dto.product.ProductDTO;
import com.practice.catalogservice.service.catagoryDetails.CategoryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/category-details")
public class CategoryDetailsController {
    @Autowired
    CategoryDetailsService categoryDetailsService;

    @GetMapping("/categoryid/{id}")
    public ResponseEntity<Collection<ProductDTO>> getCategoryDetails(@PathVariable("id") String categoryId) {
        Collection<ProductDTO> categoriesDetails = categoryDetailsService.getCategoryDetails(categoryId);
        return ResponseEntity.ok(categoriesDetails);
    }

    @PostMapping
    public ResponseEntity<ProductDetails> insertProduct(@RequestBody ProductDetailInsert productDetailInsert) {
        ProductDetails productDetails;
        try {
            productDetails = categoryDetailsService.createProduct(productDetailInsert);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(productDetails);
    }
}
