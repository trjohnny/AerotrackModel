package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trip {
    private List<Flight> outboundFlights;
    private List<Flight> returnFlights;
    private Integer totalPrice;
}