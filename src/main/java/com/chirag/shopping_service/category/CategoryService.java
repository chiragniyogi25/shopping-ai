package com.chirag.shopping_service.category;

import com.chirag.shopping_service.product.ProductMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;
    private final CategoryMapper mapper;

    public CategoryService(CategoryRepository repo, CategoryMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)//adding this hibernate session will be active since lazy fileds are also fetched
    @Cacheable("category") //it will not hit DB if cache data is found
    public List<CategoryDTO> getAllCategories() {
        //using DTO to fetch it to avoid redis serialization
        List<Category> categoryList= repo.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for(Category c:categoryList){
            categoryDTOList.add(mapper.mapCategoryToCategoryDTO(c));
        }
        return categoryDTOList;
    }

    @CacheEvict(value = "category", allEntries = true)//DB amd cache both will get updated
    @Transactional
    public Category save(Category p){
        return repo.save(p);
    }
}