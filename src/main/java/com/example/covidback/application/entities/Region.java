package com.example.covidback.application.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "regions")
@Data
public class Region {

    @Id
    private String id;
    private String label;
    private String latitude;
    private String longitude;
    private int activeCases;
    private int deathsCases;
    private int recoveredCases;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

}
