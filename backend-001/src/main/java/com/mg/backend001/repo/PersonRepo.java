package com.mg.backend001.repo;

import com.mg.backend001.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

    Person findByPersonalNumber(String personalNumber);
    Person findByEmail(String email);
    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);
}
