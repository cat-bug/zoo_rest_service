package com.sample.zoorestservice.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Document
@AllArgsConstructor
public class VisitReservation {

    @Id
    private String id;

    private String fullName;

    private int numberOfSeats;

    private OffsetDateTime dateTime;

}
