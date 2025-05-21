package com.tuapp.bibliotecaapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String nacionalidad;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Libro> libros;

    public Autor() {
        this.libros = new ArrayList<>();
    }

    public Autor(String nombre, String nacionalidad, List<Libro> libros) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
        for (Libro libro : libros) {
            libro.setAutor(this);
        }
    }

    // Método para añadir un libro y mantener la relación
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        libro.setAutor(this);
    }

    // Método para eliminar un libro y mantener la relación
    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
        libro.setAutor(null);
    }
}
