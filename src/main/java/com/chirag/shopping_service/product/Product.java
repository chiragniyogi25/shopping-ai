package com.chirag.shopping_service.product;

import com.chirag.shopping_service.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {// adding serializable since Spring is trying to save Product object in Redis

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    // used later for region-based recommendation
    private String regionTag;
    private Integer stock;
    // 📂 Many products belong to one category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

}
