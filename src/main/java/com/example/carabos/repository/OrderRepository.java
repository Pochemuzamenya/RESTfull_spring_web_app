package com.example.carabos.repository;

import com.example.carabos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    /*@Query("select o from Order_table o join fetch o.user where o.id=:id")
    Order findByJoinFetch(Long id);*/
}
