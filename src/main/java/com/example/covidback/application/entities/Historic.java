package com.example.covidback.application.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historic")
@Data
public class Historic {

    @Id
    private String id;
    private String dateLabel;
    private Integer testseffectues;
    private Integer casnegatifs;
    private Integer caspositifs;
    private Integer casdecedes;
    private Integer casretablis;
    private Integer nouveauxcaspositifs;
    private Integer nouveaucasnegatifs;
    private Integer nouveaucasdecedes;
    private Integer nouveaucasretablis;

}
