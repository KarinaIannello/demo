package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_id_sequence",
            sequenceName = "person_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_id_sequence"
    )
    private Long id;
    private Long dni;
    private String nombre;
    private String apellido;
    private String domicilio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Person() {
    }

    public Person(Long id, Long dni, String nombre, String apellido, String domicilio) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
    }
}
