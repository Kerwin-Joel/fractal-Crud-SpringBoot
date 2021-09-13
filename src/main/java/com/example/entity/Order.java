package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document( collection = "orders")
public class Order {
//    "_id" : ObjectId("613da2b86ec48e673646bbe7"),
//    "numberOrder" : 1.0,
//    "status" : "completed",
//    "date" : "18/09/2021",
//    "customer" : "kerwin",
//    "taxesAmount" : 0.18,
//    "taxesTotal" : 2.0,
//    "totalAmount" : 5.0,
//    "products" : [
//    DBRef("products", ObjectId("613da0e76ec48e673646bbdf"))
    @Id
    private String id;

    private String numberOrder;
    private String status;
    private String date;
    private String customer;
//    private double quantity;
//
//    public double getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(double quantity) {
//        this.quantity = quantity;
//    }

    @Transient
    private double taxesAmount;//subtotal de la suma de los precios de la lista de los productos
    @Transient
    private double taxesTotal;
    @Transient
    private double totalAmount;

    @DBRef
    private List<Product> products;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(String numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTaxesAmount() {
        if ( products != null && products.size() > 0){
            int total = 0 ;
            for(Product product: products){
                total += product.getUnitPrice();
            }
            return  total;
        }
        return 00.00;
    }

    public void setTaxesAmount(double taxesAmount) {
        this.taxesAmount = taxesAmount;
    }

    public double getTaxesTotal() {

        Double summary = this.getTaxesAmount();

        Double cityTax = (summary * 10) / 100;
        Double countryTax = (summary * 5) / 100;
        Double stateTax = (summary * 8) / 100;
        Double federalTax = (summary * 2) / 100;

        Double total = cityTax + countryTax + stateTax + federalTax;

        return total;
    }

    public void setTaxesTotal(double taxesTotal) {
        this.taxesTotal = taxesTotal;
    }

    public double getTotalAmount() {
        totalAmount = this.getTaxesAmount() + this.getTaxesTotal();
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }
}
