package com.example.covidback.exposition.service;

import com.example.covidback.application.entities.Historic;
import com.example.covidback.application.entities.User;
import com.example.covidback.application.models.HistoricUpdate;
import com.example.covidback.application.models.HistoricVo;
import com.example.covidback.application.models.UserVo;
import com.example.covidback.application.repositories.HistoricMongoRepository;
import com.example.covidback.application.repositories.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricService {

    @Autowired
    private HistoricMongoRepository repository;

    public List<HistoricVo> getHistoricList() {
        return repository.findAll().stream().map(historic -> mapEntityToModel(historic) ).collect(Collectors.toList());
    }

    public void updateHistoric(String date, HistoricUpdate historicUpdate) {
        Historic historic = repository.findByDateLabel(date);
        if(historic != null){
            historic.setDateLabel(date);
            historic.setTestseffectues(historicUpdate.getTestseffectues());
            historic.setCasnegatifs(historicUpdate.getCasnegatifs());
            historic.setCasdecedes(historicUpdate.getCasdecedes());
            historic.setCasretablis(historicUpdate.getCasretablis());
            historic.setCaspositifs(historicUpdate.getCaspositifs());
            historic.setNouveaucasdecedes(historicUpdate.getNouveaucasdecedes());
            historic.setNouveaucasnegatifs(historicUpdate.getNouveaucasnegatifs());
            historic.setNouveauxcaspositifs(historicUpdate.getNouveauxcaspositifs());
            historic.setNouveaucasretablis(historicUpdate.getNouveaucasretablis());
            repository.save(historic);
        }
        return;
    }

    public void saveHistoric(HistoricVo historicVo) {
        repository.save(mapModelToEntity(historicVo));
    }

    public void saveAllHistoric(List<HistoricVo> historicList) {
        List<Historic> historicVos = historicList.stream().map(historic -> repository.save(mapModelToEntity(historic)) ).collect(Collectors.toList());
    }

    public void deleteHistoric(){
        repository.deleteAll();
    }

    public HistoricVo mapEntityToModel(Historic historic){
        HistoricVo historicVo = new HistoricVo();
        historicVo.setDateLabel(historic.getDateLabel());
        historicVo.setTestseffectues(historic.getTestseffectues());
        historicVo.setCasnegatifs(historic.getCasnegatifs());
        historicVo.setCasdecedes(historic.getCasdecedes());
        historicVo.setCasretablis(historic.getCasretablis());
        historicVo.setCaspositifs(historic.getCaspositifs());
        historicVo.setNouveaucasdecedes(historic.getNouveaucasdecedes());
        historicVo.setNouveaucasnegatifs(historic.getNouveaucasnegatifs());
        historicVo.setNouveauxcaspositifs(historic.getNouveauxcaspositifs());
        historicVo.setNouveaucasretablis(historic.getNouveaucasretablis());
        return historicVo;
    }

    public Historic mapModelToEntity(HistoricVo historicVo){
        Historic historic = new Historic();
        historic.setDateLabel(historicVo.getDateLabel());
        historic.setTestseffectues(historicVo.getTestseffectues());
        historic.setCasnegatifs(historicVo.getCasnegatifs());
        historic.setCasdecedes(historicVo.getCasdecedes());
        historic.setCasretablis(historicVo.getCasretablis());
        historic.setCaspositifs(historicVo.getCaspositifs());
        historic.setNouveaucasdecedes(historicVo.getNouveaucasdecedes());
        historic.setNouveaucasnegatifs(historicVo.getNouveaucasnegatifs());
        historic.setNouveauxcaspositifs(historicVo.getNouveauxcaspositifs());
        historic.setNouveaucasretablis(historicVo.getNouveaucasretablis());
        return historic;
    }



}
