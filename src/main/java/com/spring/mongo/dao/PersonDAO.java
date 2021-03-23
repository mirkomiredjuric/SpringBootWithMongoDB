package com.spring.mongo.dao;

import com.spring.mongo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class PersonDAO {

    @Autowired
    private final PersonRepository personRepository;

    public PersonDAO( PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public Person insertPerson(Person person){
        return personRepository.save(person);
    }

    public Collection<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(String id){
        return personRepository.findById(id);
    }

    public Person updatePersonById(String id, Person person){
        Optional<Person> findPerson = personRepository.findById(id);
        Person personToBeUpdate = findPerson.get();
        personToBeUpdate.setId(person.getId());
        personToBeUpdate.setName(person.getName());

        return personRepository.save(personToBeUpdate);
    }

    public void deletePersonById(String id){
        try {
            personRepository.deleteById(id);
        }catch (NoSuchElementException noSuchElementException){
            noSuchElementException.printStackTrace();
        }
    }
}
