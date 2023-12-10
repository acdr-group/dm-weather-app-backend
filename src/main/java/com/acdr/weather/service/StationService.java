package com.acdr.weather.service;

import com.acdr.weather.entity.Station;
import com.acdr.weather.helper.RestClient;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.Cacheable;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class StationService {

    private final KlimaCacheService cacheService;

    public final List<Station> getStations() {
        return cacheService.get("/stations", new ParameterizedTypeReference<List<Station>>() {}).getBody();
    }

    public final Station getStationById(final int id) {
        var stationFound = this.getStations().stream()
                .filter(station -> Objects.equals(station.getId(), id))
                .toList()
                .stream()
                .findFirst();
        return stationFound.orElse(null);
    }
}
