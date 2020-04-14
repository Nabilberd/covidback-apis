package com.example.covidback.application.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class HistoricVo {

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
