package com.example.covidback.application.repositories;

import com.example.covidback.application.entities.Region;
import com.example.covidback.application.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionMongoRepository extends MongoRepository<Region, Integer> {
    Region findByLabel(String label);
}
