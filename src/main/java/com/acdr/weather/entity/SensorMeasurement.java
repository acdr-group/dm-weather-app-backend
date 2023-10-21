package com.acdr.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorMeasurement {


    private int id;
    private Double avg;
    private Double max;
    private Double min;
    private String name;
    private String unit;
    private List<Double> values;

    @JsonProperty("max_abs")
    private Double maxAbs;

    @JsonProperty("min_abs")
    private Double minAbs;

    @JsonProperty("the_sums")
    private List<Double> theSums;

    private String description;

    @JsonProperty("public_name")
    private String publicName;

    @JsonProperty("running_sum")
    private List<String> runningSum;
}
