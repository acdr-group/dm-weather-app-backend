package com.acdr.weather.service;

import com.acdr.weather.entity.Sensor;
import com.acdr.weather.helper.RestClient;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SensorService {

    private final KlimaCacheService cacheService;

    public final List<Sensor> getSensorsByStationId(final int id) {
        var endpoint = "/station/" + id + "/sensors";
        var stationWithSensors = cacheService.get(endpoint, StationWithSensorsResponse.class).getBody();
        return stationWithSensors != null ? stationWithSensors.sensors : List.of();
    }

    public final Optional<Sensor> getSensorOfStationById(final int stationId, final int sensorId) {
        var sensorsOfStation = this.getSensorsByStationId(stationId);
        return sensorsOfStation
                .stream()
                .filter(s -> Objects.equals(s.getId(), sensorId))
                .findFirst();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class StationWithSensorsResponse {
        private int id;
        private @NonNull String name;
        private @NonNull String label;
        private @NonNull String country;
        private @NonNull String description;
        private @NonNull String longitude;
        private @NonNull String latitude;
        private @NonNull String altitude;
        private @NonNull List<Sensor> sensors;

        @JsonProperty(value = "extra_sensors", required = true)
        private @NonNull List<Sensor> extraSensors;

        @JsonProperty(value = "first_reading")
        private String firstReading;
    }
}
