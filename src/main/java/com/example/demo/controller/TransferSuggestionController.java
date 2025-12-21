package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.InventoryBalancerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class TransferSuggestionController {

    private final InventoryBalancerServiceImpl balancerService;

    public TransferSuggestionController(InventoryBalancerServiceImpl balancerService) {
        this.balancerService = balancerService;
    }

    @PostMapping("/generate/{productId}")
    public String generateSuggestions(@PathVariable Long productId) {
        balancerService.generateSuggestions(productId);
        return "Suggestions generated";
    }

    @GetMapping("/store/{storeId}")
    public List<TransferSuggestion> getSuggestionsForStore(@PathVariable Long storeId) {
        return balancerService.getSuggestionsForStore(storeId);
    }

    @GetMapping("/{id}")
    public TransferSuggestion getSuggestionById(@PathVariable Long id) {
        return balancerService.getSuggestionById(id);
    }
}
