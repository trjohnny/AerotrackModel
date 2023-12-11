package com.aerotrack.model.protocol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ScanQueryRequest {
    private Integer minDays;
    private Integer maxDays;
    private String availabilityStart;
    private String availabilityEnd;
    private List<String> departureAirports;
    private List<String> destinationAirports;
    private Boolean returnToSameAirport;

    public void validate() throws IllegalArgumentException {
        LocalDate today = LocalDate.now();
        LocalDate start = LocalDate.parse(availabilityStart, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate end = LocalDate.parse(availabilityEnd, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate oneYearFromNow = today.plusYears(1);

        if (minDays < 0) throw new IllegalArgumentException("minDays must be greater or equal than 0");
        if (minDays > maxDays) throw new IllegalArgumentException("minDays must not exceed maxDays");
        if (maxDays >= 90) throw new IllegalArgumentException("maxDays must be less than 90");
        if (start.isBefore(today)) throw new IllegalArgumentException("availabilityStart must be a future date");
        if (start.isAfter(end)) throw new IllegalArgumentException("availabilityStart must be before availabilityEnd");
        if (maxDays - minDays < end.toEpochDay() - start.toEpochDay()) throw new IllegalArgumentException("maxDays - minDays must be greater than or equal to availabilityEnd - availabilityStart");
        if (end.isAfter(oneYearFromNow)) throw new IllegalArgumentException("availabilityEnd must be within one year from today");
    }
}
