package com.example.covidback.application.repositories;

import com.example.covidback.application.entities.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryMongoRepository extends MongoRepository<Country, Integer> {
    Country findByLabel(String label);
}
