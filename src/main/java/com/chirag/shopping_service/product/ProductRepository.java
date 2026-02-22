package com.chirag.shopping_service.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /** Adding the join query since for Redis Cacheable it will throw errors,
     *  since for category object it requires proxy to fetch data
     *  proxy needs session later, so it fails for cache/serialization**/
    @Query("SELECT p FROM Product p JOIN FETCH p.category")
    List<Product> findAllWithCategory();
}

