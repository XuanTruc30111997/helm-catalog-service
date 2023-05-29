package com.practice.catalogservice.dto.product;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInsert {
    private String title;
    private Float price;
}
