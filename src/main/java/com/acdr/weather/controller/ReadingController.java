package com.acdr.weather.controller;

import com.acdr.weather.entity.*;
import com.acdr.weather.service.ReadingService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(ApiRoute.READINGS_ROUTE)
@Slf4j
@AllArgsConstructor
public class ReadingController {

    private final ReadingService readingService;

    @GetMapping()
    public ReadingForMultipleSensors getReadings(
            final @RequestParam @NonNull String start,
            final @RequestParam @NonNull String end,
            final @RequestParam @NonNull String[] stations,
            final @RequestParam @NonNull String[] sensors,
            final @RequestParam(required = false) String timezone
    ) {
        return readingService.getReadingsByParameters(start, end, stations, sensors, timezone);
    }

    @GetMapping("/{stationId}/{sensorId}/{timestamp}/{timespan}")
    public ReadingResponse getReadingsByStationIdAndSensorIdInGivenTimespan(
            final @PathVariable int stationId,
            final @PathVariable int sensorId,
            final @PathVariable @NonNull String timestamp,
            final @PathVariable int timespan
    ) {
        return new ReadingResponse(readingService.getReadingsByStationIdAndSensorIdInGivenTimespan(
                stationId, sensorId, timestamp, timespan
        ));
    }


    @Data
    @AllArgsConstructor
    public static class ReadingResponse {
        @NonNull List<Reading> readings;
    }
}
