package com.practice.catalogservice.dto.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private String id;
    private String title;
}
