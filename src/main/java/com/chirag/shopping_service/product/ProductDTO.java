package com.chirag.shopping_service.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private double productPrice;
    private String productRegionTag;
    private Integer productAvailability;
    private String productCategoryName;
}
