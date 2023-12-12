package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trip {
    private List<Flight> outboundFlights;
    private List<Flight> returnFlights;
    private Integer totalPrice;
}