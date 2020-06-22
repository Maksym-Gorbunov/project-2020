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
public class PesonController {

    @Autowired
    private PersonService service;

    @GetMapping("/{personal_number}")
    public ResponseEntity<PersonModel> getPersonByPersonalNumber (@PathVariable String personal_number) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPersonByPersonalNumber(personal_number));
    }

    @GetMapping("/*")
    public ResponseEntity<Iterable<PersonModel>> getAllPersons() throws Exception {
        Iterable<PersonModel> result = service.getAllPersons();
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

    @DeleteMapping("/{personal_number}")
    public ResponseEntity<String> deletePerson(@PathVariable String personal_number) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletePerson(personal_number));
    }

}
