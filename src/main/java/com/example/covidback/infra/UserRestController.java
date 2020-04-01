package com.example.covidback.infra;


import com.example.covidback.application.models.UserVo;
import com.example.covidback.exposition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserVo>> getUserList() {
        return new ResponseEntity<>(service.getUserList(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody UserVo UserVo) {
        service.saveUser(UserVo);
        return new ResponseEntity<>("New user successfully saved", HttpStatus.OK);
    }

}
