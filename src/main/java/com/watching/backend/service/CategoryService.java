package com.watching.backend.service;

import com.watching.backend.domain.category.Category;
import com.watching.backend.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Cacheable(value = "categories", key = "'store_category'")
    public List<Category> getAllCategory() {
        List<Category> categories =  categoryRepository.findAll();
        return categories;
    }

}
