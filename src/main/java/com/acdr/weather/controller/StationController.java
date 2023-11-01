package com.acdr.weather.controller;

import com.acdr.weather.entity.Sensor;
import com.acdr.weather.entity.Station;
import com.acdr.weather.service.SensorService;
import com.acdr.weather.service.StationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRoute.STATIONS_ROUTE)
@CrossOrigin(origins = "*")
@Slf4j
@AllArgsConstructor
public class StationController {

    private final StationService stationService;
    private final SensorService sensorService;

    @GetMapping()
    public StationResponse getStations() {
        return new StationResponse(stationService.getStations());
    }

    @GetMapping("/{id}")
    public Station getStationById(@PathVariable int id) {
        return stationService.getStationById(id);
    }

    @GetMapping("/{id}/sensors")
    public SensorResponse getSensorsByStationId(@PathVariable int id) {
        return new SensorResponse(sensorService.getSensorsByStationId(id));
    }

    @GetMapping("/{stationId}/sensors/{sensorId}")
    public ResponseEntity<Sensor> getSensorOfStationById(@PathVariable int stationId, @PathVariable int sensorId) {
        var sensorResult = sensorService.getSensorOfStationById(stationId, sensorId);

        return sensorResult.map(sensor -> ResponseEntity
                .status(HttpStatus.OK)
                .body(sensor)
        ).orElseGet(() -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null));

    }

    @Data
    @AllArgsConstructor
    public static class StationResponse {
        @NonNull List<Station> stations;
    }

    @Data
    @AllArgsConstructor
    public static class SensorResponse {
        @NonNull List<Sensor> sensors;
    }
}
