package com.acdr.weather.service;

import com.acdr.weather.entity.Reading;
import com.acdr.weather.entity.SensorMeasurement;
import com.acdr.weather.entity.SensorReadingForStation;
import com.acdr.weather.helper.ClassObjectToListConverter;
import com.acdr.weather.helper.RestClient;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReadingService {

    private final RestClient restClient;

    public final List<Reading> getReadingsByStationIdAndSensorIdInGivenTimespan(
            final int stationId,
            final int sensorId,
            final String timestamp,
            final int timespan) {

        var endpoint = "/last_readings"
                .concat("/")
                .concat(String.valueOf(stationId))
                .concat("/")
                .concat(String.valueOf(sensorId))
                .concat("/")
                .concat(timestamp)
                .concat("/")
                .concat(String.valueOf(timespan));

        var readings = restClient.get(endpoint, ReadingResponse.class).getBody();
        return readings != null ? readings.readings : List.of();
    }

    public final List<SensorMeasurement> getReadingsByParameters(
            final @NonNull String start,
            final @NonNull String end,
            final @NonNull String[] stations,
            final @NonNull String[] sensors,
            final @Nullable String timezone
    ) {
        StringBuilder endpoint = new StringBuilder();
        StringBuilder stationsQueryParam = new StringBuilder();
        StringBuilder sensorsQueryParam = new StringBuilder();

        for (String station : stations) {
            stationsQueryParam.append("&stations=".concat(station));
        }

        for (String sensor : sensors) {
            sensorsQueryParam.append("&sensors=".concat(sensor));
        }

        endpoint.append("/readings")
                .append("?start=")
                .append(start)
                .append("&")
                .append("end=")
                .append(end)
                .append("&")
                .append(stationsQueryParam)
                .append(sensorsQueryParam);

        if (timezone != null) {
            endpoint.append("&")
                    .append("timezone=")
                    .append(timezone);
        }

        var readings = restClient.get(endpoint.toString(), ReadingWithChartDataResponse.class).getBody();
        assert readings != null;
        var sensorsByName = readings.data.get(0).getSensorsByName();

        return ClassObjectToListConverter.convert(sensorsByName);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class ReadingResponse {

        @JsonProperty(value = "from_timestamp", required = true)
        private @NonNull String fromTimestamp;

        @JsonProperty(value = "to_timestamp", required = true)
        private @NonNull String toTimestamp;

        @JsonProperty(required = true)
        private @NonNull List<Reading> readings;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class ReadingWithChartDataResponse {

        @JsonProperty("from_timestamp")
        private @NonNull String fromTimestamp;

        @JsonProperty("to_timestamp")
        private @NonNull String toTimestamp;

        @JsonProperty()
        private String resolution;

        @JsonProperty("time")
        private List<String> timeStamps;

        @JsonProperty("data")
        private @NonNull List<SensorReadingForStation> data;
    }
}
