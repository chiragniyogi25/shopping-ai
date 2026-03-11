package com.chirag.shopping_service.product;
/** Map Struct class  - Map struct is used to map to DTOs**/
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "id",target = "productId")
    @Mapping(source = "name",target = "productName")
    @Mapping(source = "price",target = "productPrice")
    @Mapping(source = "regionTag",target = "productRegionTag")
    @Mapping(source = "stock",target = "productAvailability")
    @Mapping(source = "category.name",target = "productCategoryName")
    ProductDTO mapProductToProductDTO(Product product);
}
