package com.practice.catalogservice.dto.categoryDetails;

import com.practice.catalogservice.dto.product.ProductDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProductDetails extends ProductDTO {
    private String categoryName;
}
