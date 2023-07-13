package com.example.demo.services;

import com.example.demo.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    Optional<Person> buscarPorId(Long id) throws Exception;

    Person registrar(Person person) throws Exception;

    List<Person> listarTodos();

   Person actualizar(Person person) throws Exception;
}
