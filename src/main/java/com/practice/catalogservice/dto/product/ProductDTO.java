package com.practice.catalogservice.dto.product;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProductDTO {
    private String productId;
    private String productName;
    private Float productPrice;
}
