package com.chirag.shopping_service.category;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }
    @PostMapping()
    @CacheEvict(value = "category", allEntries = true)//DB amd cache both will get updated
    public Category add(@RequestBody Category c) {
        return repo.save(c);
    }

    @GetMapping
    @Cacheable("category")
    public List<Category> all() {
        return repo.findAll();
    }
}
