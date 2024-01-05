package com.engineerpro.first.helloworld.services;

import com.engineerpro.first.helloworld.dto.CategoryDTO;
import com.engineerpro.first.helloworld.model.Category;
import com.engineerpro.first.helloworld.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    /**
     * @param category
     * @return
     */
    @Override
    public Category createCategory(CategoryDTO category) {
        Category newCategory = Category
                .builder()
                .name(category.getName())
                .build();
        return categoryRepository.save(newCategory);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    /**
     * @return
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * @param categoryId
     * @param category
     * @return
     */
    @Override
    public Category updateCategory(long categoryId, CategoryDTO category) {
        Category existingCategory = getCategoryById(categoryId);
        existingCategory.setName(category.getName());
        return existingCategory;
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public void deleteCategory(long id) throws Exception {
        categoryRepository.deleteById(id);
    }
}
