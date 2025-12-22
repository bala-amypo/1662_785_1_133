package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TransferSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store sourceStore;

    @ManyToOne
    private Store targetStore;

    @ManyToOne
    private Product product;

    private Integer quantity;
    private String priority; // HIGH / MEDIUM / LOW
    private String status = "PENDING";
    private LocalDateTime suggestedAt = LocalDateTime.now();

    // getters & setters
}
