package com.example.covidback.application.repositories;

import com.example.covidback.application.entities.Historic;
import com.example.covidback.application.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoricMongoRepository extends MongoRepository<Historic, Integer> {
    Historic findByDateLabel(String date);
}
