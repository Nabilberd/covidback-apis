package com.example.covidback.exposition.service;

import com.example.covidback.application.entities.User;
import com.example.covidback.application.models.UserVo;
import com.example.covidback.application.repositories.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserMongoRepository repository;

    public List<UserVo> getUserList() {
        return repository.findAll().stream().map(user -> {
            UserVo userVo = new UserVo();
            userVo.setIdUser(user.getIdUser());
            userVo.setName(user.getName());
            userVo.setAge(user.getAge());
            return userVo;
        }).collect(Collectors.toList());
    }

    public void saveUser(UserVo userVo) {
        User user = new User();
        user.setName(userVo.getName());
        user.setName(userVo.getName());
        user.setAge(userVo.getAge());
        repository.save(user);
    }

}
