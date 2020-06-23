package com.mg.backend001.rest;

import com.mg.backend001.model.PersonModel;
import com.mg.backend001.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/*")
    public ResponseEntity<Iterable<PersonModel>> getAllPersons() throws Exception {
        Iterable<PersonModel> result = service.getAllPersons();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonModel> getPersonById (@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPersonById(id));
    }

    @GetMapping("/personalnumber/{personalNumber}")
    public ResponseEntity<PersonModel> getPersonByPersonalNumber (@PathVariable String personalNumber) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPersonByPersonalNumber(personalNumber));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PersonModel> getPersonByEmail (@PathVariable String email) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPersonByEmail(email));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Iterable<PersonModel>> getPersonsByName (@PathVariable String name) throws Exception {
        Iterable<PersonModel> result = service.getPersonsByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<PersonModel> createPerson (@Valid @RequestBody PersonModel personModel ) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPerson(personModel));
    }

    @PatchMapping
    public ResponseEntity<PersonModel> updatePerson (@Valid @RequestBody PersonModel personModel ) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePerson(personModel));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletePersonById(id));
    }

    @DeleteMapping("/personalnumber/{personalNumber}")
    public ResponseEntity<String> deletePersonByPersonalNumber(@PathVariable String personalNumber) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletePersonByPersonalNumber(personalNumber));
    }

}
