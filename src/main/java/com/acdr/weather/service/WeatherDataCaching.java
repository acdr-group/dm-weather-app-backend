package com.acdr.weather.service;

import com.acdr.weather.entity.Forecast;
import com.acdr.weather.entity.ForecastBulk;
import com.acdr.weather.entity.Weather;
import com.acdr.weather.entity.WeatherBulk;
import com.acdr.weather.helper.RestClient;
import com.acdr.weather.helper.WeatherConverter;
import com.acdr.weather.repository.WeatherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
@EnableScheduling
@AllArgsConstructor
public class WeatherDataCaching {

    private final RestClient restClient;

    private final WeatherRepository weatherRepository;

    @Scheduled(fixedRate = 3600000)
    public void refreshWeatherInDatabase() {
        try {
            log.info("Updating weather data into the database from Data provider...");
            Weather currentWeather = loadWeather();
            Forecast forecast = loadForecast();
            currentWeather.setCurrent(true);
            resetWeatherDataInDatabase();
            weatherRepository.save(currentWeather);
            weatherRepository.saveAll(forecast.getWeatherList());
        } catch (Exception e) {
            log.error("Error updating weather data:", e);
        }
    }

    public Weather loadWeather() {
        var endpoint = "/weather";
        var bulkData = restClient.get(endpoint, WeatherBulk.class).getBody();
        assert bulkData != null;
        return WeatherConverter.convertWeatherBulkToWeather(bulkData);

    }

    public Forecast loadForecast() {
        var endpoint = "/forecast";
        var bulkData = restClient.get(endpoint, ForecastBulk.class).getBody();
        assert bulkData != null;
        var weatherList = bulkData.getWeatherList()
                .stream()
                .map(WeatherConverter::convertWeatherBulkToWeather)
                .collect(Collectors.toList());

        return Forecast.builder()
                .weatherList(weatherList)
                .build();
    }

    public void resetWeatherDataInDatabase() {
        weatherRepository.deleteAll();
    }
}
