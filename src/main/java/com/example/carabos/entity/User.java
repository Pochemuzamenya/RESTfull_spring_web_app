package com.example.carabos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_table")
@Data
@NoArgsConstructor
public class User {

    private @Id @GeneratedValue Long id;
    private String name;
    private String login;
    private String password;
    private Role role;
    private String email;

    public User(String name, String login, String password, Role role, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
