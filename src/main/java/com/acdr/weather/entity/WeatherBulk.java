package com.acdr.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherBulk {

    private Coordinate coord;

    private List<WeatherItem> weather;

    private String base;

    private MainWeatherParams main;

    private Integer visibility;

    private Integer pop;

    private WindParams wind;

    private CloudParams clouds;

    private Integer dt;

    private LocationSystemParam sys;

    private Integer timezone;

    private Integer id;

    private String name;

    private Integer cod;

    @JsonProperty("dt_txt")
    private String dateTimeText;

}
