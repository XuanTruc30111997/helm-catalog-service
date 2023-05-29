package com.practice.catalogservice.service.category;

import com.practice.catalogservice.dto.category.CategoryDTO;
import com.practice.catalogservice.dto.category.CategoryInsert;

import java.util.Collection;

public interface CategoryService {
    String insertCategory(CategoryInsert category);
    Collection<CategoryDTO> getAllCategory();

    CategoryDTO getCategory(String categoryId) throws Exception;
}
