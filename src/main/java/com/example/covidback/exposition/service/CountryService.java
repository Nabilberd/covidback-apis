package com.example.covidback.exposition.service;

import com.example.covidback.application.entities.Country;
import com.example.covidback.application.entities.Region;
import com.example.covidback.application.models.CountryUpdate;
import com.example.covidback.application.models.CountryVo;
import com.example.covidback.application.models.RegionVo;
import com.example.covidback.application.models.StateUpdate;
import com.example.covidback.application.repositories.CountryMongoRepository;
import com.example.covidback.application.repositories.RegionMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryMongoRepository repository;

    @Autowired
    RegionService regionService;

    @Autowired
    RegionMongoRepository regionMongoRepository;

    public List<CountryVo> getCountryList() {
        return repository.findAll().stream().map(region -> {
            CountryVo countryVo = new CountryVo();
            countryVo.setLabel(region.getLabel());
            countryVo.setTotalActive(region.getTotalActive());
            countryVo.setTotalDied(region.getTotalDied());
            countryVo.setTotalRecovered(region.getTotalRecovered());
            countryVo.setTotalExclus(region.getTotalExclus());
            countryVo.setLastModifiedDate(region.getLastModifiedDate());
            countryVo.setRegions(region.getRegions().stream().map(countyone -> regionService.mapEntityToModel(countyone)).collect(Collectors.toList()));
            return countryVo;
        }).collect(Collectors.toList());
    }

    public void saveCountry(CountryVo countryVo) {
        Country country = new Country();
        country.setLabel(countryVo.getLabel());
        country.setTotalActive(countryVo.getTotalActive());
        country.setTotalDied(countryVo.getTotalDied());
        country.setTotalRecovered(countryVo.getTotalRecovered());
        country.setTotalExclus(countryVo.getTotalExclus());
        country.setLastModifiedDate(countryVo.getLastModifiedDate());

        List<Region> regionList = regionMongoRepository.saveAll(countryVo.getRegions().stream().map(countyone -> {
            Region region = regionService.mapModelToEntity(countyone);
            return region;
        }).collect(Collectors.toList()));

        country.setRegions(regionList);
        repository.save(country);
    }

    public void updateCountry(String label, CountryUpdate countryUpdate) {
        Country country = repository.findByLabel(label);
        if(countryUpdate.getTotalActive() != null) country.setTotalActive(countryUpdate.getTotalActive());
        if(countryUpdate.getTotalDied() != null) country.setTotalDied(countryUpdate.getTotalDied());
        if(countryUpdate.getTotalRecovered() != null) country.setTotalRecovered(countryUpdate.getTotalRecovered());
        if(countryUpdate.getTotalExclus() != null) country.setTotalExclus(countryUpdate.getTotalExclus());
        if(countryUpdate.getLastModifiedDate() != null) country.setLastModifiedDate(stringToDate(countryUpdate.getLastModifiedDate()));

        repository.save(country);
    }

    public LocalDateTime stringToDate(String heure){
        LocalDate date = LocalDate.now();
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(heure, parser);
        LocalDateTime localDateTime = LocalDateTime.of(date, time);
        return localDateTime;
    }


}
