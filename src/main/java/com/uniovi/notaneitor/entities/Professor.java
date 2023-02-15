package com.uniovi.notaneitor.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Professor {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String categoria;


    public Professor(Long id, String nombre, String apellidos, String dni, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
