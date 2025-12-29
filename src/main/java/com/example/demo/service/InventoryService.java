package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
import java.util.List;

public interface InventoryService {

    InventoryLevel update(Long storeId, Long productId, Integer quantity);

    List<InventoryLevel> getByStore(Long storeId);
}
