package com.example.demo.service.impl;

import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store create(Store store) {
        if (storeRepository.findByStoreName(store.getStoreName()).isPresent()) {
            throw new BadRequestException("Store name already exists");
        }
        return storeRepository.save(store);
    }

    @Override
    public Store get(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }
}
