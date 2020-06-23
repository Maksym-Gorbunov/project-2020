package com.mg.backend001.repo;

import com.mg.backend001.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {


    Optional<Person> findByPersonalNumber(String personalNumber);
    Optional<Person> findByEmail(String email);
    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);
    Long deleteByPersonalNumber(String personalNumber);
    List<Person> removeByPersonalNumber(String personalNumber);
}
