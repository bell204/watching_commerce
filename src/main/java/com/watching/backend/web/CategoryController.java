package com.watching.backend.web;

import com.watching.backend.domain.category.Category;
import com.watching.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categoryList = categoryService.getAllCategory();
        return ResponseEntity.ok().body(categoryList);
    }
}
