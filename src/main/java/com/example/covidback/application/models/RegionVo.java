package com.example.covidback.application.models;

import lombok.Data;

@Data
public class RegionVo {

    private String label;
    private String latitude;
    private String longitude;
    private int activeCases;
    private int deathsCases;
    private int recoveredCases;

}
