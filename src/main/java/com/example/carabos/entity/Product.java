package com.example.carabos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Product_table")
public class Product {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String title;
    private Float price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Order order;

    public Product(String title, Float price) {
        this.title = title;
        this.price = price;
    }
}
