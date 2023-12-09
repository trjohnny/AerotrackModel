package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FlightPair {
    private Flight outboundFlight;
    private Flight returnFlight;
    private Integer totalPrice;
}