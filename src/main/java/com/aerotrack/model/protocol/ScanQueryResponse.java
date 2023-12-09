package com.aerotrack.model.protocol;

import com.aerotrack.model.entities.FlightPair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScanQueryResponse {
    List<FlightPair> flightPairs;
}