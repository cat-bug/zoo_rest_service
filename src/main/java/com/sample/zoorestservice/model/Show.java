package com.sample.zoorestservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Getter
public class Show {

    @Id
    private String showId;

    private String name;

    private String schedule;

}
