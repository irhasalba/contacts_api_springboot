package com.learn.spring.learn_spring.controller;

import com.learn.spring.learn_spring.model.Person;
import com.learn.spring.learn_spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPerson();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Person getPerson = personService.getPersonById(id);
        if(getPerson == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(getPerson);
        }
    }
    @PostMapping()
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createPerson = personService.createPerson(person);
        if(createPerson == null) {
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(createPerson);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id,@RequestBody Person person) {
        Person reqPerson = new Person();
        reqPerson.SetName(person.getName());
        reqPerson.SetEmail(person.getEmail());
        reqPerson.SetAddress(person.getAddress());
        Person updatePerson = personService.updatePerson(id,reqPerson);
        if(updatePerson == null) {
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(updatePerson);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
