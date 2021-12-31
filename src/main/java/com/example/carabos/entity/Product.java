package com.example.carabos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Product_table")
public class Product {

    private @Id @GeneratedValue Long id;
    private String title;
    private Float price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
