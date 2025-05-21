package com.tuapp.bibliotecaapi.repository;

import com.tuapp.bibliotecaapi.model.Autor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNombreContainingIgnoreCase(String nombre);
}

