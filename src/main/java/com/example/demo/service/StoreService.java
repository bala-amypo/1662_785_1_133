package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store create(Store store) {
        if (storeRepository.findByStoreName(store.getStoreName()).isPresent()) {
            throw new BadRequestException("Store name already exists");
        }
        return storeRepository.save(store);
    }

    public Store get(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public List<Store> getAll() {
        return storeRepository.findAll();
    }
}
