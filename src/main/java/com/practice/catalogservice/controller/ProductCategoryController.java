package com.practice.catalogservice.controller;

import com.practice.catalogservice.dto.productCategory.ProductCategoryDTO;
import com.practice.catalogservice.dto.productCategory.ProductCategoryInsert;
import com.practice.catalogservice.service.productCategory.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<Void> postProductCategory(@RequestBody ProductCategoryInsert productCategory) {
        productCategoryService.insertProductCategory(productCategory);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/categoryid/{id}")
    public ResponseEntity<Collection<ProductCategoryDTO>> getCategoryDetails(@PathVariable("id") String categoryId) {
        Collection<ProductCategoryDTO> categoriesDetails = productCategoryService.getProductCategoryByCategoryId(categoryId);
        return ResponseEntity.ok(categoriesDetails);
    }

    @GetMapping("/productid/{id}")
    public ResponseEntity<Collection<ProductCategoryDTO>> getCategoryDetailsWithProductId(@PathVariable("id") String productId) {
        Collection<ProductCategoryDTO> productDetails = productCategoryService.getProductCategoryByProductId(productId);
        return ResponseEntity.ok(productDetails);
    }
}
