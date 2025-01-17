package com.example.covidback.application.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "countries")
@Data
public class Country {

    @Id
    private String idCountry;
    private String label;
    private LocalDateTime lastModifiedDate;
    private int totalActive;
    private int totalDied;
    private int totalRecovered;
    private int totalExclus;

    @DBRef
    private List<Region> regions;


}
