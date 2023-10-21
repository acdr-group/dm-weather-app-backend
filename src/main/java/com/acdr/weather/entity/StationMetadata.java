package com.acdr.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StationMetadata {

    @JsonProperty()
    private int id;

    @JsonProperty()
    private @NonNull String name;
}
