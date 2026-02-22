package com.chirag.shopping_service.product;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping()
    public Product add(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping
    public List<ProductDTO> all() {
        return service.getAllProducts();
    }
}
