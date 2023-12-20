package com.acdr.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainWeatherParams {

    private Double temp;

    @JsonProperty("feels_like")
    private Double feelsLike;

    @JsonProperty("temp_min")
    private Double tempMin;

    @JsonProperty("temp_max")
    private Double tempMax;

    private Double pressure;

    private Double humidity;

    @JsonProperty("sea_level")
    private Double pressureSeaLevel;

    @JsonProperty("grnd_level")
    private Double pressureGroundLevel;
}
