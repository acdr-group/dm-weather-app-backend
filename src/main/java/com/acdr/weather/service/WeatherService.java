package com.acdr.weather.service;

import com.acdr.weather.entity.Weather;
import com.acdr.weather.repository.WeatherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@EnableScheduling
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public final Weather getCurrentWeather() {
        return weatherRepository.findByIsCurrent(true);
    }
}
