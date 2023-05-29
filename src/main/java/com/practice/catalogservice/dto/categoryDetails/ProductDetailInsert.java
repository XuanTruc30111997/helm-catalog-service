package com.practice.catalogservice.dto.categoryDetails;

import com.practice.catalogservice.dto.product.ProductInsert;

import lombok.Data;

@Data
public class ProductDetailInsert extends ProductInsert {
    private String categoryId;
}
