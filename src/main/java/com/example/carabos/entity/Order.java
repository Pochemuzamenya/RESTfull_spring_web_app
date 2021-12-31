package com.example.carabos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Order_table")
@NoArgsConstructor
public class Order {
    private @Id @GeneratedValue Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User customer;
    private Date date;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
}
