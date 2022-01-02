package com.example.carabos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "User_table")
@Data
@NoArgsConstructor
public class User {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private String login;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    private String email;

    public User(String name, String login, String password, Role role, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public Long getNextId() {
        return id + 1;
    }
}
