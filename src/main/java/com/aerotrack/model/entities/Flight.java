package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@DynamoDbBean
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private String direction;
    private String departureDateTime;
    private String arrivalDateTime;
    private String airline;
    private String updatedDateTime;
    private Long TTL;
    private Double price;

    public Flight(String airportFromCode, String airportToCode, String departureDateTime, String arrivalDateTime, String airline, double price) {
        this.direction = airportFromCode + "-" + airportToCode;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.airline = airline;
        this.price = price;

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.updatedDateTime = currentDateTime.format(formatter);


        try  {
            LocalDateTime departureLocalDateTime = LocalDateTime.parse(departureDateTime, formatter);
            this.TTL = departureLocalDateTime.toEpochSecond(java.time.ZoneOffset.UTC);
        }
        catch (DateTimeParseException exc) {
            System.err.println("You provided a wrong datetime format");
        }
    }

    @DynamoDbSortKey
    public String getDepartureDateTime() { return departureDateTime; }

    @DynamoDbPartitionKey
    public String getDirection() { return direction; }
}
