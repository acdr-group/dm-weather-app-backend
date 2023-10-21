package com.acdr.weather.controller;

import com.acdr.weather.entity.Sensor;
import com.acdr.weather.entity.Station;
import com.acdr.weather.service.SensorService;
import com.acdr.weather.service.StationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiRoute.STATIONS_ROUTE)
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
