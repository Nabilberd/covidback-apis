package com.example.covidback.infra;

import com.example.covidback.application.models.HistoricUpdate;
import com.example.covidback.application.models.HistoricVo;
import com.example.covidback.application.models.RegionVo;
import com.example.covidback.application.models.StateUpdate;
import com.example.covidback.exposition.service.HistoricService;
import com.example.covidback.exposition.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HistoricRestController {

    @Autowired
    private HistoricService service;

    @GetMapping("/historics")
    public ResponseEntity<List<HistoricVo>> getUserList() {
        return new ResponseEntity<>(service.getHistoricList(), HttpStatus.OK);
    }

    @PostMapping("/allHistoric")
    public ResponseEntity<String> saveAllHistoric(@RequestBody List<HistoricVo> historicVoList) {
        service.saveAllHistoric(historicVoList);
        return new ResponseEntity<>("Historics successfully saved", HttpStatus.OK);
    }

    @PostMapping("/historic")
    public ResponseEntity<String> saveHistoric(@RequestBody HistoricVo historicVo) {
        service.saveHistoric(historicVo);
        return new ResponseEntity<>("New Historic successfully saved", HttpStatus.OK);
    }

    @PostMapping("/updateHistoric")
    public ResponseEntity<String> updateHistoric(@RequestParam("label") String label, @RequestBody HistoricUpdate historicUpdate) {
        service.updateHistoric(label, historicUpdate);
        return new ResponseEntity<>("Historic updated successfully saved", HttpStatus.OK);
    }

    @DeleteMapping("/deleteHistorics")
    public ResponseEntity<String> updateHistoric( ) {
        service.deleteHistoric();
        return new ResponseEntity<>("Historics deleted successfully saved", HttpStatus.OK);
    }

}
