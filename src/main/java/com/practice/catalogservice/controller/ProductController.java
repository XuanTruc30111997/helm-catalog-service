package com.practice.catalogservice.controller;

import com.practice.catalogservice.dto.product.ProductDTO;
import com.practice.catalogservice.dto.product.ProductInsert;
import com.practice.catalogservice.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<String> insertProduct(@RequestBody ProductInsert product) {
        String productId = productService.insertProduct(product);
        return ResponseEntity.ok().body(productId);
    }

    @GetMapping
    public ResponseEntity<Collection<ProductDTO>> getAllProduct() {
        Collection<ProductDTO> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") String productId) {
        ProductDTO product = productService.getProductById(productId);

        return ResponseEntity.ok(product);
    }
}
