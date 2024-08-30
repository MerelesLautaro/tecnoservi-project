package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Order;
import com.lautadev.tecnoservi_project.repository.IOrderRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrder(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void editOrder(Long id, Order order) {
        Order orderEdit = this.findOrder(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        NullAwareBeanUtils.copyNonNullProperties(order,orderEdit);

        orderRepository.save(orderEdit);
    }
}
