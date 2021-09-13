package com.example.service;

import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    public Product createOrder(Product product){

        return productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(String id){
        return productRepository.findById(id).get();
    }
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
    public String deleteProduct(String id){
        productRepository.deleteById(id);
        return "La orden fue borrado con exito";
    }
}
