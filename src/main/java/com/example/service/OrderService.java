package com.example.service;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    public Order createOrder(Order order){
        if(order.getProducts() != null && order.getProducts().size() > 0){
            productRepository.saveAll(order.getProducts());
        }
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Order getOrderById(String id){
        return orderRepository.findById(id).get();
    }
    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }
    public String deleteOrder(String id){
        orderRepository.deleteById(id);
        return "La orden fue borrado con exito";
    }
}
