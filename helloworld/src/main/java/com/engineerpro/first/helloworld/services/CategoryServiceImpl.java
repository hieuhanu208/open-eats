package com.engineerpro.first.helloworld.services;

import com.engineerpro.first.helloworld.dto.CategoryDTO;
import com.engineerpro.first.helloworld.model.Category;

import java.util.List;

public interface CategoryServiceImpl {
    Category createCategory(CategoryDTO category);
    Category getCategoryById(long id);
    List<Category> getAllCategories();
    Category updateCategory(long categoryId, CategoryDTO category);
    void deleteCategory(long id) throws Exception;
}
