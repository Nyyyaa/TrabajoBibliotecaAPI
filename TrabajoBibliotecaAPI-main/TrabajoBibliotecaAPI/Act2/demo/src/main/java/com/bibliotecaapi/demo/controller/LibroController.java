package com.bibliotecaapi.demo.controller;

import com.bibliotecaapi.demo.model.Libro;
import com.bibliotecaapi.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroDetalles.getTitulo());
            libro.setIsbn(libroDetalles.getIsbn());
            libro.setAnioPublicacion(libroDetalles.getAnioPublicacion());
            return libroRepository.save(libro);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }
}