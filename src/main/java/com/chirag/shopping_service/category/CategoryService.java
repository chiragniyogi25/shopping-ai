package com.chirag.shopping_service.category;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)//adding this hibernate session will be active since lazy fileds are also fetched
    @Cacheable("category") //it will not hit DB if cache data is found
    public List<CategoryDTO> getAllCategories() {
        //using DTO to fetch it to avoid redis serialization
        return repo.findAll()
                .stream()
                .map(c -> new CategoryDTO(
                        c.getId(),
                        c.getName(),
                        c.getDescription()
                ))
                .toList();
    }

    @CacheEvict(value = "category", allEntries = true)//DB amd cache both will get updated
    @Transactional
    public Category save(Category p){
        return repo.save(p);
    }
}