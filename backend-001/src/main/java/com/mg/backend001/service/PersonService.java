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
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repository;
    @Autowired
    private Mapper mapper;


    public PersonModel getPersonById(Long id) throws ResourceNotFoundException {
        Optional<Person> person = repository.findById(id);
        if (person.isEmpty()){
            throw new ResourceNotFoundException("person with id '"+id+"' not found");
        }
        return mapper.toModel(person.get());
    }

    public PersonModel getPersonByPersonalNumber(String personalNumber) throws ResourceNotFoundException {
        Optional<Person> person = repository.findByPersonalNumber(personalNumber);
        if (person.isEmpty()){
            throw new ResourceNotFoundException("person with personal number '"+personalNumber+"' not found");
        }
        return mapper.toModel(person.get());
    }


    public PersonModel getPersonByEmail(String email) throws ResourceNotFoundException {
        Optional<Person> person = repository.findByEmail(email);
        if (person.isEmpty()){
            throw new ResourceNotFoundException("person with email '"+email+"' not found");
        }
        return mapper.toModel(person.get());
    }

    public Iterable<PersonModel> getPersonsByName(String name) throws ResourceNotFoundException {
        List<Person> personsByFirstName = repository.findByFirstName(name);
        List<Person> personsByLastName = repository.findByLastName(name);
        if ((personsByFirstName==null && personsByLastName==null)
        || (personsByFirstName.isEmpty() && personsByLastName.isEmpty())){
            throw new ResourceNotFoundException("persons with name '"+name+"' found");
        }
        if(personsByFirstName==null || personsByFirstName.isEmpty()){
            return mapper.toModels(personsByLastName);
        }
        if(personsByLastName==null || personsByLastName.isEmpty()){
            return mapper.toModels(personsByFirstName);
        }
        List<Person> persons = new ArrayList<>();
        persons.addAll(personsByFirstName);
        for(Person person : personsByLastName){
            if(!persons.contains(person)){
                persons.add(person);
            }
        }
        return mapper.toModels(persons);
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

    public String deletePersonById(Long id) throws ResourceNotFoundException {
        getPersonById(id);
        repository.deleteById(id);
        return "Country with id '" + id + "' was successfully deleted";
    }

    public String deletePersonByPersonalNumber(String personalNumber) throws ResourceNotFoundException {
        getPersonByPersonalNumber(personalNumber);
        //repository.removeByPersonalNumber(personalNumber);
        //repository.removeByPersonalNumber(personalNumber);
        System.out.println("111");
        repository.deleteByPersonalNumber(personalNumber);
        return "Country with id '" + personalNumber + "' was successfully deleted";
    }
}
