package com.acdr.weather.repository;

import com.acdr.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, UUID> {

//    @Query("SELECT DISTINCT FROM weather WHERE is_current = TRUE")
//    public Weather findCurrent();

    Weather findByIsCurrent(boolean isCurrent);



}
