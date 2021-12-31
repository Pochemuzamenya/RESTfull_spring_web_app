package com.example.carabos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User_table")
@Data
@NoArgsConstructor
public class User {

    private @Id @GeneratedValue Long id;
    private String name;
    private String login;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> order = new ArrayList<>();

    public User(String name, String login, String password, Role role, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
