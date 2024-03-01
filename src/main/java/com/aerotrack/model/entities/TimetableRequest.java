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
public class TimetableRequest {
    private List<WizzAirFlight> flightList;
    private String priceType;
    private Integer adultCount;
    private Integer childCount;
    private Integer infantCount;
}

