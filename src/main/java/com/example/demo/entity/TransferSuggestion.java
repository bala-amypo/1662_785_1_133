package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer_suggestion")
public class TransferSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Store sourceStore;

    @ManyToOne(optional = false)
    private Store targetStore;

    @ManyToOne(optional = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String priority; // HIGH / MEDIUM / LOW

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING / APPROVED / REJECTED

    private LocalDateTime suggestedAt = LocalDateTime.now();

    // getters and setters
}
