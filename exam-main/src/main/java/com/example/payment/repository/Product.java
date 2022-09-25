package com.example.payment.repository;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    Integer price ;

}
