package com.mg.backend001.repo;

import com.mg.backend001.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

    Person findByPersonalNumber(String personalNumber);
}
