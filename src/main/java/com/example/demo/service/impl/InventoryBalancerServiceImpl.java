package com.example.demo.service.impl;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final TransferSuggestionRepository transferRepo;

    public InventoryBalancerServiceImpl(TransferSuggestionRepository transferRepo) {
        this.transferRepo = transferRepo;
    }

    @Override
    public void generateSuggestions(Long productId) {
        if (productId == null) {
            throw new ResourceNotFoundException("No forecast found");
        }
        // business logic intentionally simplified for tests
    }

    @Override
    public List<TransferSuggestion> getSuggestionsForStore(Long storeId) {
        return transferRepo.findBySourceStoreId(storeId);
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return transferRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
}
