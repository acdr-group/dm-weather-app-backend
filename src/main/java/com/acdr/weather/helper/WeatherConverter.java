package com.acdr.weather.helper;

import com.acdr.weather.entity.Weather;
import com.acdr.weather.entity.WeatherBulk;

public abstract class WeatherConverter {

    public static Weather convertWeatherBulkToWeather(WeatherBulk weatherBulk) {
        return Weather.builder()
                .main(weatherBulk.getWeather().get(0).getMain())
                .description(weatherBulk.getWeather().get(0).getDescription())
                .icon(weatherBulk.getWeather().get(0).getIcon())
                .temp(weatherBulk.getMain().getTemp())
                .feelsLike(weatherBulk.getMain().getFeelsLike())
                .tempMin(weatherBulk.getMain().getTempMin())
                .tempMax(weatherBulk.getMain().getTempMax())
                .pressure(weatherBulk.getMain().getPressure())
                .humidity(weatherBulk.getMain().getHumidity())
                .pressureSeaLevel(weatherBulk.getMain().getPressureSeaLevel())
                .pressureGroundLevel(weatherBulk.getMain().getPressureGroundLevel())
                .visibility(weatherBulk.getVisibility())
                .wind(weatherBulk.getWind())
                .clouds(weatherBulk.getClouds())
                .dateTime(weatherBulk.getDt())
                .dateTimeText(weatherBulk.getDateTimeText())
                .sunrise(weatherBulk.getSys().getSunrise())
                .sunset(weatherBulk.getSys().getSunset())
                .timezone(weatherBulk.getTimezone())
                .cityName(weatherBulk.getName())
                .build();
    }
}
