package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    public void saveOrder(Order order);
    public List<Order> getOrders();
    public Optional<Order> findOrder(Long id);
    public void deleteOrder(Long id);
    public void editOrder(Long id, Order order);
}
