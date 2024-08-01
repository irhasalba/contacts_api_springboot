package com.learn.spring.learn_spring.controller;

import com.learn.spring.learn_spring.model.Users;
import com.learn.spring.learn_spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> registerUser(@RequestBody Users users){
        Users createUser = usersService.registerUsers(users);
        if(createUser == null){
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(createUser);
        }
    }

}
