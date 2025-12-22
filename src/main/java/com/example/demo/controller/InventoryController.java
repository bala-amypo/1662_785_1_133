package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PutMapping("/update")
    public InventoryLevel updateInventory(
            @RequestParam Long storeId,
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        return inventoryService.update(storeId, productId, quantity);
    }

    @GetMapping("/store/{storeId}")
    public List<InventoryLevel> getInventoryByStore(@PathVariable Long storeId) {
        return inventoryService.getByStore(storeId);
    }
}
