package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
@DynamoDbBean
@ToString
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Flight {
    private String direction;
    private String departureDateTime;
    private String arrivalDateTime;
    private String flightNumber;
    private String updatedDateTime;
    private double price;

    public Flight(String airportFromCode, String airportToCode, String departureDateTime, String arrivalDateTime, String flightNumber, double price) {
        this.direction = airportFromCode + "-" + airportToCode;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.flightNumber = flightNumber;
        this.price = price;

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        this.updatedDateTime = currentDateTime.format(formatter);
    }



    @DynamoDbSortKey
    public String getDepartureDateTime() { return departureDateTime; }
    public void setDepartureDateTime(String departureDateTime) { this.departureDateTime = departureDateTime; }

    @DynamoDbPartitionKey
    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }
}
