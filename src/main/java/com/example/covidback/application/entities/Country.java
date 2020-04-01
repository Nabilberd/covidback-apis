package com.example.covidback.application.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "countries")
@Data
public class Country {

    @Id
    private String idUser;
    private String name;
    private int totalVictime;
    private int totalDie;
    private int totalRecovered;

}
