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
public class Sensor {

    @JsonProperty(required = true)
    private int id;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String unit;

    @JsonProperty(value = "last_value", required = true)
    private String lastValue;

    @JsonProperty()
    private String description;

    @JsonProperty(value = "last_timestamp", required = true)
    private String lastTimestamp;

    @JsonProperty(value = "last_reading_in_minutes", required = true)
    private int lastReadingInMinutes;
}
