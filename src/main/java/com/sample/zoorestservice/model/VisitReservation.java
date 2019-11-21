package com.sample.zoorestservice.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@AllArgsConstructor
public class VisitReservation {

    @Id
    private String id;

    private String fullName;

    private int numberOfSeats;

    private LocalDate dateTime;

}
