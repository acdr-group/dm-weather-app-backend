package com.acdr.weather.controller;

import com.acdr.weather.entity.Forecast;
import com.acdr.weather.service.ForecastService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.FORECAST_ROUTE)
public class ForecastController {

    private final ForecastService forecastService;

    @GetMapping
    Forecast getForecast(final @RequestParam Map<String, String> params) {
        return forecastService.getForecast(params);
    }
}
