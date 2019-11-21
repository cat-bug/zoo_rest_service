package com.sample.zoorestservice.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@AllArgsConstructor
public class ShowReservation {

    @Id
    private String id;

    @DBRef
    private Show show;

    private String fullName;

    private int numberOfSeats;

    private LocalDate dateTime;

}
