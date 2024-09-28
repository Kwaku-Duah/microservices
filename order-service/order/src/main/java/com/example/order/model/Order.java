package com.example.order.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customer-orders") 
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private int quantity;

}
