package com.practice.catalogservice.service.catagoryDetails;

import com.practice.catalogservice.dto.categoryDetails.ProductDetailInsert;
import com.practice.catalogservice.dto.categoryDetails.ProductDetails;
import com.practice.catalogservice.dto.product.ProductDTO;

import java.util.Collection;

public interface CategoryDetailsService {
    Collection<ProductDTO> getCategoryDetails(String categoryId);
    ProductDetails createProduct(ProductDetailInsert productDetailInsert) throws Exception;
}
