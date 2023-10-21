package com.acdr.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorReadingForStation {

    @JsonProperty("station")
    private @NonNull StationMetadata stationMetadata;

    @JsonProperty("sensors")
    private @NonNull SensorByName sensorsByName;
}
