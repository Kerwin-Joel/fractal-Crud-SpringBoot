package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createOrder(product);
    }
    @GetMapping("/all")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/byId/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}
