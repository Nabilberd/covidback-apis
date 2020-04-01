package com.example.covidback.exposition.service;

import com.example.covidback.application.entities.Region;
import com.example.covidback.application.models.RegionVo;
import com.example.covidback.application.models.StateUpdate;
import com.example.covidback.application.repositories.RegionMongoRepository;
import com.example.covidback.application.repositories.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionService {

    @Autowired
    private RegionMongoRepository repository;

    public List<RegionVo> getRegionList() {
        return repository.findAll().stream().map(region -> mapEntityToModel(region)).collect(Collectors.toList());
    }

    public void saveRegion(RegionVo regionVo) {
        repository.save(mapModelToEntity(regionVo));
    }

    public void updateRegion(String label, StateUpdate stateUpdate) {
        Region region = repository.findByLabel(label);
        if(stateUpdate.getActiveCases() != null) region.setActiveCases(stateUpdate.getActiveCases());
        if(stateUpdate.getDeathsCases() != null) region.setDeathsCases(stateUpdate.getDeathsCases());
        if(stateUpdate.getRecoveredCases() != null) region.setRecoveredCases(stateUpdate.getRecoveredCases());
        repository.save(region);
    }

    public RegionVo mapEntityToModel(Region region){
        RegionVo regionVo = new RegionVo();
        regionVo.setLabel(region.getLabel());
        regionVo.setLatitude(region.getLatitude());
        regionVo.setLongitude(region.getLongitude());
        regionVo.setActiveCases(region.getActiveCases());
        regionVo.setDeathsCases(region.getDeathsCases());
        regionVo.setRecoveredCases(region.getRecoveredCases());
        return regionVo;
    }

    public Region mapModelToEntity(RegionVo regionVo){
        Region region = new Region();
        region.setLabel(regionVo.getLabel());
        region.setLatitude(regionVo.getLatitude());
        region.setLongitude(regionVo.getLongitude());
        region.setActiveCases(regionVo.getActiveCases());
        region.setDeathsCases(regionVo.getDeathsCases());
        region.setRecoveredCases(regionVo.getRecoveredCases());
        return region;
    }


}
