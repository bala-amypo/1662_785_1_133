package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class TransferSuggestionController {

    private final InventoryBalancerService inventoryBalancerService;

    public TransferSuggestionController(InventoryBalancerService inventoryBalancerService) {
        this.inventoryBalancerService = inventoryBalancerService;
    }

    @PostMapping("/generate/{productId}")
    public String generateSuggestions(@PathVariable Long productId) {
        inventoryBalancerService.generateSuggestions(productId);
        return "Transfer suggestions generated";
    }

    @GetMapping("/store/{storeId}")
    public List<TransferSuggestion> getSuggestionsForStore(@PathVariable Long storeId) {
        return inventoryBalancerService.getSuggestionsForStore(storeId);
    }

    @GetMapping("/{id}")
    public TransferSuggestion getSuggestionById(@PathVariable Long id) {
        return inventoryBalancerService.getSuggestionById(id);
    }
}
