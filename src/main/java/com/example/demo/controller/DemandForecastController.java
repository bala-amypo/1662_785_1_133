package com.example.demo.controller;

import com.example.demo.entity.DemandForecast;
import com.example.demo.service.DemandForecastService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forecasts")
public class DemandForecastController {

    private final DemandForecastService demandForecastService;

    public DemandForecastController(DemandForecastService demandForecastService) {
        this.demandForecastService = demandForecastService;
    }

    @PostMapping
    public DemandForecast createForecast(@RequestBody DemandForecast forecast) {
        return demandForecastService.createForecast(forecast);
    }

    @GetMapping("/store/{storeId}/product/{productId}")
    public DemandForecast getForecast(
            @PathVariable Long storeId,
            @PathVariable Long productId) {

        return demandForecastService.getForecast(storeId, productId);
    }
}
