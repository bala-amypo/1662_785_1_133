package com.example.demo.repository;

import com.example.demo.entity.DemandForecast;
import com.example.demo.entity.Store;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DemandForecastRepository extends JpaRepository<DemandForecast, Long> {

    Optional<DemandForecast> findByStoreAndProductAndForecastDateAfter(
            Store store,
            Product product,
            LocalDate date
    );
}
