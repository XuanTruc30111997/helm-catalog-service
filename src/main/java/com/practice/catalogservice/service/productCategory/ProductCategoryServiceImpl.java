package com.practice.catalogservice.service.productCategory;

import com.practice.catalogservice.dto.productCategory.ProductCategoryInsert;
import com.practice.catalogservice.model.ProductCategory;
import com.practice.catalogservice.dto.productCategory.ProductCategoryDTO;
import com.practice.catalogservice.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public void insertProductCategory(ProductCategoryInsert productCategory) {
        productCategoryRepository.insertProductCategory(productCategory.getProductId(), productCategory.getCategoryId());
    }

    @Override
    public Collection<ProductCategoryDTO> getProductCategoryByProductId(String productId) {
        Collection<ProductCategory> productCategories = productCategoryRepository.getProductCategoryByProductId(productId);

        return productCategories.stream().map(productCategory -> ProductCategoryDTO.builder()
                .categoryId(productCategory.getCategoryId())
                .productId(productCategory.getProductId())
                .build()).collect(Collectors.toList());
    }

    @Override
    public Collection<ProductCategoryDTO> getProductCategoryByCategoryId(String categoryId) {
        Collection<ProductCategory> productCategories = productCategoryRepository.getProductCategoryByCategory(categoryId);

        return productCategories.stream().map(productCategory -> ProductCategoryDTO.builder()
                .categoryId(productCategory.getCategoryId())
                .productId(productCategory.getProductId())
                .build()).collect(Collectors.toList());
    }
}
