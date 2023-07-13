package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonReposiroty extends JpaRepository<Person, Long> {
    Optional<Person>  findById (Long id);
    Optional<Person> findByDni(Long dni);
}
