package com.example.demo.service;

import com.example.demo.entity.DemandForecast;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DemandForecastService {

    private final DemandForecastRepository forecastRepo;
    private final StoreRepository storeRepo;
    private final ProductRepository productRepo;

    public DemandForecastService(DemandForecastRepository forecastRepo,
                                 StoreRepository storeRepo,
                                 ProductRepository productRepo) {
        this.forecastRepo = forecastRepo;
        this.storeRepo = storeRepo;
        this.productRepo = productRepo;
    }

    public DemandForecast create(DemandForecast forecast) {

        if (!forecast.getForecastDate().isAfter(LocalDate.now())) {
            throw new BadRequestException("Forecast date must be in the future");
        }

        return forecastRepo.save(forecast);
    }

    public DemandForecast get(Long storeId, Long productId) {

        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        List<DemandForecast> list = forecastRepo
                .findByStoreAndProductAndForecastDateAfter(store, product, LocalDate.now());

        if (list.isEmpty()) {
            throw new BadRequestException("No forecast found");
        }

        return list.get(0);
    }
}
