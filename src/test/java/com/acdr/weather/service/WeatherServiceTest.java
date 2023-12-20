package com.acdr.weather.service;

import com.acdr.weather.entity.*;
import com.acdr.weather.helper.WeatherConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(WeatherService.class)
public class WeatherServiceTest {

    @MockBean
    private WeatherService weatherService;

    private Weather mockWeather;

    @BeforeEach
    public void setup() {
        Coordinate mockCoord = new Coordinate();
        mockCoord.setLat(10.0);
        mockCoord.setLon(20.0);

        List<WeatherItem> mockWeatherItems = new ArrayList<>();
        WeatherItem mockWeatherItem = new WeatherItem();
        mockWeatherItem.setMain("Rain");
        mockWeatherItem.setDescription("Light rain");
        mockWeatherItem.setIcon("10d");
        mockWeatherItems.add(mockWeatherItem);

        MainWeatherParams mockMain = new MainWeatherParams();
        mockMain.setTemp(25.0);
        mockMain.setHumidity(40.0);
        mockMain.setPressure(1013.25);

        WindParams mockWind = new WindParams();
        mockWind.setSpeed(20.0);
        mockWind.setGust(30.0);
        mockWind.setDeg(180.0);

        CloudParams mockClouds = new CloudParams();
        mockClouds.setAll(60);

        WeatherBulk mockWeatherBulk = new WeatherBulk();
        mockWeatherBulk.setDt(1643195200);
        mockWeatherBulk.setDateTimeText("2022-10-11 16:00:00");
        mockWeatherBulk.setCoord(mockCoord);
        mockWeatherBulk.setWeather(mockWeatherItems);
        mockWeatherBulk.setBase("stations");
        mockWeatherBulk.setMain(mockMain);
        mockWeatherBulk.setVisibility(1000);
        mockWeatherBulk.setPop(0);
        mockWeatherBulk.setWind(mockWind);
        mockWeatherBulk.setClouds(mockClouds);
        mockWeatherBulk.setSys(new LocationSystemParam());
        mockWeatherBulk.setTimezone(1);
        mockWeatherBulk.setId(1836751);
        mockWeatherBulk.setName("Stuttgart");
        mockWeatherBulk.setCod(200);

        mockWeather = WeatherConverter.convertWeatherBulkToWeather(mockWeatherBulk);

        when(weatherService.getCurrentWeather(any())).thenReturn(mockWeather);
    }

    @Test
    public void weatherDataResponseShouldNotBeNull() {
        Weather actualWeather = weatherService.getCurrentWeather(new HashMap<>());
        assertNotEquals(actualWeather, null);
    }

    @Test
    public void shouldLoadCurrentWeatherDataOfSpecifiedLocation() {

        Weather actualWeather = weatherService.getCurrentWeather(new HashMap<>());

        assertNotEquals(mockWeather, null);
        assertEquals(mockWeather.getCityName(), actualWeather.getCityName());
        assertEquals(mockWeather.getMain(), actualWeather.getMain());
        assertEquals(mockWeather.getDescription(), actualWeather.getDescription());
        assertEquals(mockWeather.getIcon(), actualWeather.getIcon());
        assertEquals(mockWeather.getTemp(), actualWeather.getTemp());
        assertEquals(mockWeather.getHumidity(), actualWeather.getHumidity());
    }

    @Test
    public void responseShouldContainMainWeatherData() {
        Weather actualWeather = weatherService.getCurrentWeather(new HashMap<>());

        assertEquals(mockWeather.getMain(), actualWeather.getMain());
        assertEquals(mockWeather.getTemp(), actualWeather.getTemp());
        assertEquals(mockWeather.getTempMin(), actualWeather.getTempMin());
        assertEquals(mockWeather.getHumidity(), actualWeather.getHumidity());
        assertEquals(mockWeather.getHumidity(), actualWeather.getHumidity());
    }
}
