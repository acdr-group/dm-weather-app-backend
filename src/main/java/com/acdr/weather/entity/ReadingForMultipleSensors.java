package com.acdr.weather.entity;

import lombok.NonNull;
import java.util.List;

public record ReadingForMultipleSensors(@NonNull List<SensorMeasurement> sensorMeasurements, @NonNull List<String> time) {}
