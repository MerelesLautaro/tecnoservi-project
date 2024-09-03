package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.dto.OrderDTO;
import com.lautadev.tecnoservi_project.model.Order;
import com.lautadev.tecnoservi_project.repository.IOrderRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<OrderDTO> getOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for(Order order:orderList){
            orderDTOS.add(OrderDTO.fromOrder(order));
        }

        return orderDTOS;
    }

    @Override
    public Optional<OrderDTO> findOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
        return Optional.ofNullable(OrderDTO.fromOrder(order));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void editOrder(Long id, Order order) {
        Order orderEdit = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(order,orderEdit);

        orderRepository.save(orderEdit);
    }
}
