package com.example.carabos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "Order_table")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customer;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Order(User customer, Date date, Status status) {
        this.customer = customer.getName();
        this.date = date;
        this.status = status;
    }
}
