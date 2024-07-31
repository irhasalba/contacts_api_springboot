package com.learn.spring.learn_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;

    // Getter and Setter
    public void SetName(String personName) {
        this.name = personName;
    }
    public void SetAddress(String personAddress) {
        this.address = personAddress;
    }
    public void SetEmail(String personEmail) {
        this.email = personEmail;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getEmail() {
        return this.email;
    }
}
