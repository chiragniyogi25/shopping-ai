package com.chirag.shopping_service.category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "id" , target = "categoryId")
    @Mapping(source = "name" , target = "categoryName")
    @Mapping(source = "description" , target = "categoryDescription")
    CategoryDTO mapCategoryToCategoryDTO(Category category);
}
