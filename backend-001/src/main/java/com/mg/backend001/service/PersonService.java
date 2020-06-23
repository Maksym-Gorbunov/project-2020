package com.mg.backend001.service;

import com.mg.backend001.config.Mapper;
import com.mg.backend001.config.exception.exc.ResourceNotFoundException;
import com.mg.backend001.entity.Person;
import com.mg.backend001.model.PersonModel;
import com.mg.backend001.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repository;
    @Autowired
    private Mapper mapper;


    public PersonModel getPersonById(Long id) throws ResourceNotFoundException {
        Person person = repository.getOne(id);
        if (person==null){
            throw new ResourceNotFoundException("person not found");
        }
        return mapper.toModel(person);
    }

    public PersonModel getPersonByPersonalNumber(String personalNumber) throws ResourceNotFoundException {
        Person person = repository.findByPersonalNumber(personalNumber);
        if (person==null){
            throw new ResourceNotFoundException("person not found");
        }
        return mapper.toModel(person);
    }

    public Iterable<PersonModel> getAllPersons() {
        List<Person> personList = repository.findAll();
        if (personList == null) {
            System.out.println("error in getAllPersons()");
            //throw new ResourceNotFoundException("resource 'code' not found");
        }
        if (personList.isEmpty()) {
            return new ArrayList<>();
        }
        return mapper.toModels(personList);
    }

    public PersonModel createPerson(PersonModel personModel) {
        Person person = mapper.toEntity(personModel);
        Person savedPerson = repository.save(person);
        if (savedPerson == null) {
            System.out.println("error in createPerson()");
            //throw new ResourceCreationException("unable to save 'code'");
        }
        return mapper.toModel(savedPerson);
    }

    public PersonModel updatePerson(PersonModel personModel) {
        return null;
    }

    public String deletePerson(String personalNumber) {
        return null;
    }
}
