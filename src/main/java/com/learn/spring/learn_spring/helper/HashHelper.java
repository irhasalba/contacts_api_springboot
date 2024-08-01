package com.learn.spring.learn_spring.helper;

import com.password4j.Hash;
import com.password4j.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class HashHelper {

    public String generateHashPassword(String password) {
        return Password.hash(password).addRandomSalt(12).withScrypt().getResult();
    }

}
