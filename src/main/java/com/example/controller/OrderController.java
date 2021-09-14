package com.example.controller;


import com.example.entity.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
//@CrossOrigin(origins = "*", methods= {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }
    @GetMapping("/all")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/byId/{id}")
    public Order getOrderById(@PathVariable String id){
        return orderService.getOrderById(id);
    }
    @PutMapping("/update")
    public Order updateStudent(@RequestBody Order order){
        return orderService.updateOrder(order);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable String id){
        return orderService.deleteOrder(id);
    }
}
