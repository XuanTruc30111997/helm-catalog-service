package com.practice.catalogservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
@Data
public class Product {
    @Id
    private String id;
    private String title;
    private Float price;
}
