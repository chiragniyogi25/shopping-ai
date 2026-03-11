package com.chirag.shopping_service.product;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repo,ProductMapper mapper) {
        this.repo = repo;
        this.mapper=mapper;
    }

    @Transactional(readOnly = true)//adding this hibernate session will be active since lazy fields are also fetched
    @Cacheable("products") //it will not hit DB if cache data is found
    public List<ProductDTO> getAllProducts() {
        //using DTO to fetch it to avoid redis serialization
        List<Product> productList = repo.findAllWithCategory();
        List<ProductDTO> productDTOList=new ArrayList<>();
        for(Product p:productList){
            productDTOList.add(mapper.mapProductToProductDTO(p));
        }
        return productDTOList;
    }

    @CacheEvict(value = "products", allEntries = true)//DB amd cache both will get updated
    @Transactional
    public Product save(Product p){
        return repo.save(p);
    }

    @CacheEvict(value = "products", allEntries = true)
    public ProductDTO update(Long id, ProductDTO productDTO){
        //TODO add backend logic to update
        return null;
    }
}