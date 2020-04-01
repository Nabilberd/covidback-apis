package com.example.covidback.application.models;

import com.example.covidback.application.entities.Region;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CountryVo {

    private String label;
    private LocalDateTime lastModifiedDate = LocalDateTime.now();
    private int totalActive;
    private int totalDied;
    private int totalRecovered;
    private int totalExclus;

    private List<RegionVo> regions;

}
