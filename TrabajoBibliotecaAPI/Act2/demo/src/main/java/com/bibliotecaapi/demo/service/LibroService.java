package com.bibliotecaapi.demo.service;

import com.bibliotecaapi.demo.model.Libro;
import com.bibliotecaapi.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Optional<Libro> actualizarLibro(Long id, Libro libroDetalles) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroDetalles.getTitulo());
            libro.setIsbn(libroDetalles.getIsbn());
            libro.setAnioPublicacion(libroDetalles.getAnioPublicacion());
            return libroRepository.save(libro);
        });
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}