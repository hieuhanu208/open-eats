package com.engineerpro.first.helloworld.repositories;

import com.engineerpro.first.helloworld.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
