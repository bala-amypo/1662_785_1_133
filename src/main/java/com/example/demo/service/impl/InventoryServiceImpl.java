package com.example.demo.service.impl;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.entity.Store;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryLevelRepository inventoryRepo;
    private final StoreRepository storeRepo;

    public InventoryServiceImpl(InventoryLevelRepository inventoryRepo,
                                StoreRepository storeRepo) {
        this.inventoryRepo = inventoryRepo;
        this.storeRepo = storeRepo;
    }

    @Override
    public List<InventoryLevel> getByStore(Long storeId) {

        // ✔ Only validate store existence
        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        // ✔ Return empty list if no inventory
        return inventoryRepo.findByStore(store);
    }
}
