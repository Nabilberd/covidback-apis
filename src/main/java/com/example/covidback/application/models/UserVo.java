package com.example.covidback.application.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class UserVo {
    private String idUser;
    private String name;
    private int age;
}
