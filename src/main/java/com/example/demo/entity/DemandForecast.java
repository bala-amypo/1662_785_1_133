package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DemandForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private LocalDate forecastDate;
    private Integer predictedDemand;
    private Double confidenceScore;

    // REQUIRED getters
    public LocalDate getForecastDate() {
        return forecastDate;
    }

    public Integer getPredictedDemand() {
        return predictedDemand;
    }
}
