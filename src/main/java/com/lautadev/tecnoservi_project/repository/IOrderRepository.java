package com.lautadev.tecnoservi_project.repository;

import com.lautadev.tecnoservi_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
}
