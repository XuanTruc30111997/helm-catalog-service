package com.practice.catalogservice.service.product;

import com.practice.catalogservice.dto.product.ProductDTO;
import com.practice.catalogservice.dto.product.ProductInsert;

import java.util.Collection;

public interface ProductService {
    String insertProduct(ProductInsert product);
    Collection<ProductDTO> getAllProducts();
    ProductDTO getProductById(String productId);
}
