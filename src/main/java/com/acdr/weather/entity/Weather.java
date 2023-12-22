package com.acdr.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Weather {

    private String main;

    private String description;

    private String icon;

    private Double temp;

    private Double feelsLike;

    private Double tempMin;

    private Double tempMax;

    private Double pressure;

    private Double humidity;

    private Double pressureSeaLevel;

    private Double pressureGroundLevel;

    private Integer visibility;

    private Double windSpeed;

    private Double windDirection;

    private Double windGust;

    private Double clouds;

    private Integer dateTime;

    private String dateTimeText;

    private Integer sunrise;

    private Integer sunset;

    private Integer timezone;

    private String cityName;
}
