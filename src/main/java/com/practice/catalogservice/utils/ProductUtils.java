package com.practice.catalogservice.utils;

import com.practice.catalogservice.dto.product.ProductDTO;
import com.practice.catalogservice.model.Product;

import java.util.Collection;
import java.util.stream.Collectors;

public class ProductUtils {
    public static ProductDTO mapProduct(Product product) {
        return ProductDTO.builder()
                .productId(product.getId())
                .productName(product.getTitle())
                .productPrice(product.getPrice())
                .build();
    }

    public static Collection<ProductDTO> mapProducts(Collection<Product> products) {
        return products.stream().map(ProductUtils::mapProduct).collect(Collectors.toList());
    }
}
