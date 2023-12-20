package com.acdr.weather.service;

import com.acdr.weather.entity.Weather;
import com.acdr.weather.entity.WeatherBulk;
import com.acdr.weather.helper.RestClient;
import com.acdr.weather.helper.UriManager;
import com.acdr.weather.helper.WeatherConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class WeatherService {

    private final RestClient restClient;

    public final Weather getCurrentWeather(Map<String, String> params) {
        log.info("GetCurrentWeatherBulk - Query Params = {}", params);

        var endpoint = UriManager.buildUriFromQueryParams("/weather", params);

        var bulkData = restClient.get(endpoint, WeatherBulk.class).getBody();

        assert bulkData != null;

        return WeatherConverter.convertWeatherBulkToWeather(bulkData);
    }
}
