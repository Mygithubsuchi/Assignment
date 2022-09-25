package com.example.payment.model;

import java.util.List;

import lombok.Data;

@Data
public class CartModel {

    String name;
    List<String> productId;
    
}
