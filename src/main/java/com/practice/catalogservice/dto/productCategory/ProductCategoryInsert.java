package com.practice.catalogservice.dto.productCategory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoryInsert {
    private String productId;
    private String categoryId;
}
