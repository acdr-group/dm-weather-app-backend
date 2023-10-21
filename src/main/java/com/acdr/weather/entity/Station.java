package com.acdr.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Station {

    private int id;
    private String name;
    private String label;
    private String country;
    private String description;
    private String longitude;
    private String latitude;
    private String altitude;
}
