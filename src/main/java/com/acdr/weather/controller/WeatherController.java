package com.acdr.weather.controller;

import com.acdr.weather.entity.Weather;
import com.acdr.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.WEATHER_ROUTE)
public class WeatherController {

    private final WeatherService currentWeatherBulkService;

    @GetMapping
    Weather getCurrentWeather() {
        return currentWeatherBulkService.getCurrentWeather();
    }
}
