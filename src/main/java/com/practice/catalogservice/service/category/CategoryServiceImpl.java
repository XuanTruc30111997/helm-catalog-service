package com.practice.catalogservice.service.category;

import com.practice.catalogservice.dto.category.CategoryDTO;
import com.practice.catalogservice.dto.category.CategoryInsert;
import com.practice.catalogservice.model.Category;
import com.practice.catalogservice.utils.CategoryUtils;
import com.practice.catalogservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public String insertCategory(CategoryInsert category) {
        String uuid = UUID.randomUUID().toString();
        categoryRepository.insertCategory(uuid, category.getTitle());

        return uuid;
    }

    @Override
    public Collection<CategoryDTO> getAllCategory() {
        Collection<Category> categories = categoryRepository.getAllCategory();
        return CategoryUtils.mapCategories(categories);
    }

    @Override
    public CategoryDTO getCategory(String categoryId) throws Exception {
        Collection<Category> categories = categoryRepository.getCategory(categoryId);
        if (!categories.isEmpty()) {
            Optional<Category> categoryOptional = categories.stream().findFirst().filter(category -> Objects.equals(category.getId(), categoryId));
            if (categoryOptional.isPresent()) {
                return CategoryUtils.mapCategory(categoryOptional.get());
            }
        }

        throw new Exception("Cannot find category");
    }
}
