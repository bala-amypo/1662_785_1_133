package com.example.demo.service;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.repository.TransferSuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryBalancerService {

    private final TransferSuggestionRepository transferRepo;
    private final InventoryLevelRepository inventoryRepo;
    private final DemandForecastRepository forecastRepo;
    private final StoreRepository storeRepo;

    public InventoryBalancerService(
            TransferSuggestionRepository transferRepo,
            InventoryLevelRepository inventoryRepo,
            DemandForecastRepository forecastRepo,
            StoreRepository storeRepo) {

        this.transferRepo = transferRepo;
        this.inventoryRepo = inventoryRepo;
        this.forecastRepo = forecastRepo;
        this.storeRepo = storeRepo;
    }

    public List<TransferSuggestion> generate(Long productId) {
        // Placeholder for balancing logic
        return List.of();
    }

    public List<TransferSuggestion> getByStore(Long storeId) {
        return transferRepo.findBySourceStoreId(storeId);
    }
}
