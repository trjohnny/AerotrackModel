package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class WizzAirFlight {
    private String departureStation;
    private String arrivalStation;
    private String from;
    private String to;
}
