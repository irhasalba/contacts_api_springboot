package com.learn.spring.learn_spring.service;

import com.learn.spring.learn_spring.helper.HashHelper;
import com.learn.spring.learn_spring.model.Users;
import com.learn.spring.learn_spring.repository.UsersRepository;
import com.password4j.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    private HashHelper hashHelper;

    UsersService(){
        this.hashHelper = new HashHelper();
    }

    public Users registerUsers(Users users){
        Users newUsers = new Users();
        newUsers.setUsername(users.getUsername());
        newUsers.setEmail(users.getEmail());
        String password = this.hashHelper.generateHashPassword(users.getPassword());
        newUsers.setPassword(password);
        return usersRepository.save(newUsers);
    }
}
