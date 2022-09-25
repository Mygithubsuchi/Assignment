package com.example.payment.repository;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    Integer percentage ;

}
