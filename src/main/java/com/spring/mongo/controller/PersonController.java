package com.spring.mongo.controller;

import com.spring.mongo.entity.Person;
import com.spring.mongo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person insertPerson(@RequestBody Person person){
        return personService.insertPerson(person);
    }

    @GetMapping
    public Collection<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") String id){
        return personService.getPersonById(id);
    }

    @PutMapping(path = "/update/{id}")
    public Person updatePersonById(@PathVariable String id, @RequestBody Person person){
        return personService.updatePersonById(id, person);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletePerson(@PathVariable String id){
         personService.deletePerson(id);
    }

}
