package com.practice.catalogservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="product_category")
@Data
public class ProductCategory {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "productid")
    private String productId;
    @Column(name = "categoryid")
    private String categoryId;
}
