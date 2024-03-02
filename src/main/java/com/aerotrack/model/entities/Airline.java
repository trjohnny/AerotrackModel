package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Airline {
    RYANAIR("Ryanair"),
    WIZZAIR("Wizzair");

    private final String airlineName;
}
