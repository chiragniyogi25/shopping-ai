package com.chirag.shopping_service.category;

import com.chirag.shopping_service.product.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }
    @PostMapping()
    public Category add(@RequestBody Category c) {
        return repo.save(c);
    }

    @GetMapping
    public List<Category> all() {
        return repo.findAll();
    }
}
