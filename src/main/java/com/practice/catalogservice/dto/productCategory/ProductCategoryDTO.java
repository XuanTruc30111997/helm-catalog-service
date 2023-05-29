package com.practice.catalogservice.dto.productCategory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoryDTO {
    private String productId;
    private String categoryId;
}
