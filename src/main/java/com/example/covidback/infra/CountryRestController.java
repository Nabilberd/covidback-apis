package com.example.covidback.infra;

import com.example.covidback.application.models.CountryUpdate;
import com.example.covidback.application.models.CountryVo;
import com.example.covidback.application.models.RegionVo;
import com.example.covidback.application.models.StateUpdate;
import com.example.covidback.exposition.service.CountryService;
import com.example.covidback.exposition.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService service;

    @GetMapping("/countries")
    public ResponseEntity<List<CountryVo>> getCountryList() {
        return new ResponseEntity<>(service.getCountryList(), HttpStatus.OK);
    }

    @PostMapping("/country")
    public ResponseEntity<String> sqveCountry(@RequestBody CountryVo countryVo) {
        service.saveCountry(countryVo);
        return new ResponseEntity<>("New country successfully saved", HttpStatus.OK);
    }

    @PostMapping("/updateCountry")
    public ResponseEntity<String> updqteCountry(@RequestParam("label") String label, @RequestBody CountryUpdate countryUpdate) {
        service.updateCountry(label, countryUpdate);
        return new ResponseEntity<>("Country updated successfully saved", HttpStatus.OK);
    }

}
