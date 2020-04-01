package com.example.covidback.application.repositories;

import com.example.covidback.application.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, Integer> {
    User findByName(String name);
}
