package com.bibliotecaapi.demo.repository;

import com.bibliotecaapi.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {}

