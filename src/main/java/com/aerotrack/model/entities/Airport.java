package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Airport {
    private String airportCode;
    private String name;
    private String countryCode;
    private List<String> connections;
    private String lastUpdatedDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airportCode, airport.airportCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportCode);
    }
}