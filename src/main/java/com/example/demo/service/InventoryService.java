package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryLevelRepository inventoryRepo;
    private final StoreRepository storeRepo;
    private final ProductRepository productRepo;

    public InventoryService(InventoryLevelRepository inventoryRepo,
                            StoreRepository storeRepo,
                            ProductRepository productRepo) {
        this.inventoryRepo = inventoryRepo;
        this.storeRepo = storeRepo;
        this.productRepo = productRepo;
    }

    public InventoryLevel update(Long storeId, Long productId, Integer quantity) {

        if (quantity < 0) {
            throw new BadRequestException("Quantity must be >= 0");
        }

        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        InventoryLevel inventory = inventoryRepo
                .findByStoreAndProduct(store, product)
                .orElse(new InventoryLevel());

        inventory.setStore(store);
        inventory.setProduct(product);
        inventory.setQuantity(quantity);

        return inventoryRepo.save(inventory);
    }

    public List<InventoryLevel> getByStore(Long storeId) {
        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        return inventoryRepo.findByStore(store);
    }
}
