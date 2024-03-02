package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Airline {
    RYANAIR("Ryanair"),
    WIZZAIR("Wizzair");

    private final String airlineName;

    public static Airline fromName(String name) {
        return Arrays.stream(Airline.values())
                .filter(airline -> airline.getAirlineName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant " + Airline.class.getCanonicalName() + "." + name));
    }
}
