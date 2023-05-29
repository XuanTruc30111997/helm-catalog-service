package com.practice.catalogservice.service.productCategory;

import com.practice.catalogservice.dto.productCategory.ProductCategoryInsert;
import com.practice.catalogservice.dto.productCategory.ProductCategoryDTO;

import java.util.Collection;

public interface ProductCategoryService {
    void insertProductCategory(ProductCategoryInsert productCategory);
    Collection<ProductCategoryDTO> getProductCategoryByProductId(String productId);
    Collection<ProductCategoryDTO> getProductCategoryByCategoryId(String categoryId);
}
