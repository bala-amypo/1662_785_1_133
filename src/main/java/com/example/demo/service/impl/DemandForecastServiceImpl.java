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

@Service
public class DemandForecastServiceImpl implements DemandForecastService {

    private final DemandForecastRepository forecastRepo;
    private final StoreRepository storeRepo;
    private final ProductRepository productRepo;

    public DemandForecastServiceImpl(
            DemandForecastRepository forecastRepo,
            StoreRepository storeRepo,
            ProductRepository productRepo) {

        this.forecastRepo = forecastRepo;
        this.storeRepo = storeRepo;
        this.productRepo = productRepo;
    }

    @Override
    public DemandForecast createForecast(DemandForecast forecast) {

        if (forecast.getForecastDate().isBefore(LocalDate.now())) {
            throw new BadRequestException("Forecast date must be in the future");
        }

        return forecastRepo.save(forecast);
    }

    @Override
    public DemandForecast getForecast(Long storeId, Long productId) {

        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        return forecastRepo
                .findByStoreAndProductAndForecastDateAfter(store, product, LocalDate.now())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
}
