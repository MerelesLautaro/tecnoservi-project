package com.lautadev.tecnoservi_project.controller;

import com.lautadev.tecnoservi_project.dto.OrderDTO;
import com.lautadev.tecnoservi_project.model.Order;
import com.lautadev.tecnoservi_project.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return ResponseEntity.ok("Order saved successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<List<OrderDTO>> getOrders(){
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderDTO> findOrder(@PathVariable Long id){
        Optional<OrderDTO> order = orderService.findOrder(id);
        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<String> editOrder(@PathVariable Long id, @RequestBody Order order){
        orderService.editOrder(id,order);
        return ResponseEntity.ok("Order edited");
    }
}
