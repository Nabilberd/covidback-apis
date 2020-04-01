package com.example.covidback.application.models;

import lombok.Data;


@Data
public class CountryUpdate {

    private Integer totalActive;
    private Integer totalDied;
    private Integer totalRecovered;
    private Integer totalExclus;
    private String lastModifiedDate;

}
