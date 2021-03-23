package com.spring.mongo.service;

import com.spring.mongo.dao.PersonDAO;
import com.spring.mongo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Person insertPerson(Person person){
        return personDAO.insertPerson(person);
    }

    public Collection<Person> getAllPerson(){
        return personDAO.getAllPerson();
    }

    public Optional<Person> getPersonById(String id){
        return personDAO.getPersonById(id);
    }

    public Person updatePersonById(String id, Person person){
        return personDAO.updatePersonById(id, person);
    }

    public void deletePerson(String id){
        personDAO.deletePersonById(id);
    }
}
