package com.aerotrack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Airports {
    private List<Airport> airports;

    @Data
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class Airport {
        private String airportCode;
        private String name;
        private String countryCode;
        private List<String> connections;
    }
}
