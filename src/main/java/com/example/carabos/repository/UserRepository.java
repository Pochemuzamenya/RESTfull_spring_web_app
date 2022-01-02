package com.example.carabos.repository;

import com.example.carabos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /*@Query("select n from User_table where n.name = :name")
    User findByName(String name);*/
}
