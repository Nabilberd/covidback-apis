package com.example.covidback.application.models;

import lombok.Data;

@Data
public class HistoricUpdate {

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
