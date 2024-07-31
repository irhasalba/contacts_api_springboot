package com.learn.spring.learn_spring.service;

import com.learn.spring.learn_spring.model.Person;
import com.learn.spring.learn_spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }
    public Person getPersonById(Long id){
        return personRepository.findById(id).orElse(null);
    }
    public Person createPerson(Person person){
        return personRepository.save(person);
    }
    public Person updatePerson(Long id, Person person){
        Person findPerson = personRepository.findById(id).orElse(null);
        if(findPerson == null){
            return null;
        }else {
            findPerson.SetName(person.getName());
            findPerson.SetAddress(person.getAddress());
            findPerson.SetEmail(person.getEmail());
            return personRepository.save(findPerson);
        }
    }
    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
