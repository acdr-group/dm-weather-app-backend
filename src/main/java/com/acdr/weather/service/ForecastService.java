package com.acdr.weather.service;

import com.acdr.weather.entity.Forecast;
import com.acdr.weather.entity.ForecastBulk;
import com.acdr.weather.helper.RestClient;
import com.acdr.weather.helper.UriManager;
import com.acdr.weather.helper.WeatherConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ForecastService {

    private final RestClient restClient;

    public final Forecast getForecast(Map<String, String> params) {
        log.info("GetCurrentWeatherBulk - Query Params = {}", params);

        var endpoint = UriManager.buildUriFromQueryParams("/forecast", params);

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
}
