package com.example.covidback.application.models;

import lombok.Data;

@Data
public class StateUpdate {

    private Integer activeCases;
    private Integer deathsCases;
    private Integer recoveredCases;

}
