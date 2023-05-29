package com.practice.catalogservice.service.catagoryDetails;

import com.practice.catalogservice.dto.category.CategoryDTO;
import com.practice.catalogservice.dto.categoryDetails.ProductDetailInsert;
import com.practice.catalogservice.dto.categoryDetails.ProductDetails;
import com.practice.catalogservice.dto.product.ProductDTO;
import com.practice.catalogservice.dto.product.ProductInsert;
import com.practice.catalogservice.service.product.ProductService;
import com.practice.catalogservice.dto.productCategory.ProductCategoryDTO;
import com.practice.catalogservice.dto.productCategory.ProductCategoryInsert;
import com.practice.catalogservice.service.category.CategoryService;
import com.practice.catalogservice.service.productCategory.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class CategoryDetailsServiceImpl implements CategoryDetailsService {
    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Override
    public Collection<ProductDTO> getCategoryDetails(String categoryId) {
        Collection<ProductCategoryDTO> productCategories = productCategoryService.getProductCategoryByCategoryId(categoryId);

        List<CompletableFuture<ProductDTO>> features = productCategories.stream()
                .map(productCategory -> CompletableFuture.supplyAsync(() -> productService.getProductById(productCategory.getProductId())))
                .collect(Collectors.toList());

        return features.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    @Override
    public ProductDetails createProduct(ProductDetailInsert productDetailInsert) throws Exception {
        try {
            CategoryDTO category = categoryService.getCategory(productDetailInsert.getCategoryId());
            String productId = productService.insertProduct(ProductInsert.builder()
                    .title(productDetailInsert.getTitle())
                    .price(productDetailInsert.getPrice())
                    .build());

            productCategoryService.insertProductCategory(ProductCategoryInsert.builder()
                    .categoryId(category.getId())
                    .productId(productId).build());

            return ProductDetails.builder()
                    .categoryName(category.getTitle())
                    .productId(productId)
                    .productName(productDetailInsert.getTitle())
                    .productPrice(productDetailInsert.getPrice()).build();
        } catch (Exception ex) {
            throw new Exception("Error while creating product");
        }
    }
}
