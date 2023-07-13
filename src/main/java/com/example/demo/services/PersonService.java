package com.example.demo.services;

import com.example.demo.entity.Person;
import com.example.demo.repository.IPersonReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    IPersonReposiroty personReposiroty;

    @Override
    public Optional<Person> buscarPorId(Long id) throws Exception {

        Optional<Person> person = personReposiroty.findById(id);

        if(person.isEmpty()) {
            throw new Exception("No existe la persona con el id especificado");
        }
        return person;
    }

    @Override
    public Person registrar(Person p) throws Exception {

        Optional<Person> personToSave = personReposiroty.findByDni(p.getDni());

        if (personToSave.isPresent()) {
            throw new Exception("El dni especificado ya existe");
        }

        Person person = personReposiroty.save(p);
        return person;
    }

    @Override
    public List<Person> listarTodos() {

        List<Person> personas = personReposiroty.findAll();
        return personas;
    }

    @Override
    public Person actualizar(Person person) throws Exception {

        Long id = person.getId();
        Optional<Person> pEncontrada = personReposiroty.findById(id);

        if(pEncontrada.isEmpty()) {
            throw new Exception("No se encontro la persona a actualizar");
        }

        Person personActualizada = personReposiroty.save(person);

        return personActualizada;
    }

}
