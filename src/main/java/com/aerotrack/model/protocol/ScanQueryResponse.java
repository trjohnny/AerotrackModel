package com.aerotrack.model.protocol;

import com.aerotrack.model.entities.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScanQueryResponse {
    @NonNull
    List<Trip> trips;
}
