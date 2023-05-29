package com.practice.catalogservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    private String id;
    private String title;
}
