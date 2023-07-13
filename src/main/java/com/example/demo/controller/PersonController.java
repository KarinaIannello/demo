package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    IPersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> listarTodos() {
        return new ResponseEntity<>(personService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Person> buscar(@RequestParam Long id) throws Exception {

        return new ResponseEntity(personService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> guardar(@RequestBody Person person) throws Exception {

        return new ResponseEntity<>(personService.registrar(person), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Person> actualizar(@RequestBody Person person) throws Exception {

        return new ResponseEntity<>(personService.actualizar(person), HttpStatus.OK);
    }
}
