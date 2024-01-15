package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Airport {
    private String airportCode;
    private String name;
    private String countryCode;
    private List<String> connections;
    private String lastUpdatedDateTime;
}