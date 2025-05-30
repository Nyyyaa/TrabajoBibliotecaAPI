package com.tuapp.bibliotecaapi.repository;

import com.tuapp.bibliotecaapi.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByAnioPublicacion(int anio);
    List<Libro> findByTituloContainingIgnoreCaseAndAnioPublicacion(String titulo, int anio);
}


