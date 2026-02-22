package com.chirag.shopping_service.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private String regionTag;
    private Integer stock;
    private String categoryName;
}
