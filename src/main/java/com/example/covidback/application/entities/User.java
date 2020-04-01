package com.example.covidback.application.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String idUser;
    private String name;
    private int age;
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

}
