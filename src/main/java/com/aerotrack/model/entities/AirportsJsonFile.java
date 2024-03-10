package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class AirportsJsonFile {
    private Set<Airport> airports;
}
