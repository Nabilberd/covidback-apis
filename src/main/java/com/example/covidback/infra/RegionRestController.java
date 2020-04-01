package com.example.covidback.infra;

import com.example.covidback.application.models.RegionVo;
import com.example.covidback.application.models.StateUpdate;
import com.example.covidback.exposition.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionRestController {

    @Autowired
    private RegionService service;

    @GetMapping("/regions")
    public ResponseEntity<List<RegionVo>> getUserList() {
        return new ResponseEntity<>(service.getRegionList(), HttpStatus.OK);
    }

    @PostMapping("/region")
    public ResponseEntity<String> saveUser(@RequestBody RegionVo regionVo) {
        service.saveRegion(regionVo);
        return new ResponseEntity<>("New region successfully saved", HttpStatus.OK);
    }

    @PostMapping("/updateRegion")
    public ResponseEntity<String> updateUser(@RequestParam("label") String label, @RequestBody StateUpdate stateUpdate) {
        service.updateRegion(label, stateUpdate);
        return new ResponseEntity<>("Rregion updated successfully saved", HttpStatus.OK);
    }

}
