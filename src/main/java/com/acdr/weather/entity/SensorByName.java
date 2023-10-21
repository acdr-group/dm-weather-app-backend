package com.acdr.weather.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorByName {

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonProperty(value = "Luft_Temperatur")
    private @Nullable SensorMeasurement luftTemperatur;

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonProperty(value = "Luft_Feuchte")
    private @Nullable SensorMeasurement luftFeuchte;

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonProperty(value = "Niederschlag_Menge")
    private @Nullable SensorMeasurement niederschlagMenge;

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonProperty(value = "Wind_Geschwindigkeit")
    private @Nullable SensorMeasurement windGeschwindigkeit;

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonProperty(value = "Wind_Richtung")
    private @Nullable SensorMeasurement windRichtung;

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonProperty(value = "Luft_Druck")
    private @Nullable SensorMeasurement luftDruck;
}
