package com.aerotrack.model.protocol;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Builder
public class ScanQueryRequest {
    @NonNull
    private Integer minDays;
    @NonNull
    private Integer maxDays;
    @NonNull
    private String availabilityStart;
    @NonNull
    private String availabilityEnd;
    @NonNull
    private List<String> departureAirports;
    @NonNull
    private List<String> destinationAirports;
    private Integer maxChanges;
    private Integer minTimeBetweenChangesHours;
    private Integer maxTimeBetweenChangesHours;
    private Boolean returnToSameAirport;

    public ScanQueryRequest(Integer minDays, Integer maxDays, String availabilityStart, String availabilityEnd,
                            List<String> departureAirports, List<String> destinationAirports, Integer maxChanges,
                            Integer minTimeBetweenChangesHours, Integer maxTimeBetweenChangesHours, Boolean returnToSameAirport) {
        this.minDays = minDays;
        this.maxDays = maxDays;
        this.availabilityStart = availabilityStart;
        this.availabilityEnd = availabilityEnd;
        this.departureAirports = departureAirports;
        this.destinationAirports = destinationAirports;
        this.maxChanges = maxChanges;
        this.minTimeBetweenChangesHours = minTimeBetweenChangesHours;
        this.maxTimeBetweenChangesHours = maxTimeBetweenChangesHours;
        this.returnToSameAirport = returnToSameAirport;

        validate();
    }

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
        if (maxDays > end.toEpochDay() - start.toEpochDay()) throw new IllegalArgumentException("Can't stay away a number of days greater than tne availability window.");
        if (end.isAfter(oneYearFromNow)) throw new IllegalArgumentException("availabilityEnd must be within one year from today");
        if (Objects.nonNull(minTimeBetweenChangesHours) && minTimeBetweenChangesHours < 0) throw new IllegalArgumentException("minTimeBetweenChangesHours must be greater or equal than 0");
        if (Objects.nonNull(maxTimeBetweenChangesHours) && maxTimeBetweenChangesHours > 8) throw new IllegalArgumentException("maxTimeBetweenChangesHours must be less or equal than 6");
        if (Objects.nonNull(maxChanges) && (maxChanges > 2 || maxChanges < 0)) throw new IllegalArgumentException("maxChanges must be >= 0 and <= 2");

    }
}
