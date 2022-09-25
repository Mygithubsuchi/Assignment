package com.example.payment.repository;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    String cartId;
    Integer productId;

}
