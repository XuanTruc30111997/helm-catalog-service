package com.practice.catalogservice.utils;

import com.practice.catalogservice.dto.category.CategoryDTO;
import com.practice.catalogservice.model.Category;

import java.util.Collection;
import java.util.stream.Collectors;

public class CategoryUtils {

    public static CategoryDTO mapCategory(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .title(category.getTitle())
                .build();
    }

    public static Collection<CategoryDTO> mapCategories(Collection<Category> categories) {
        return categories.stream().map(CategoryUtils::mapCategory).collect(Collectors.toList());
    }
}
