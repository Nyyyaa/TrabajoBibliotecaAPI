package com.bibliotecaapi.demo.service;

import com.bibliotecaapi.demo.model.Libro;
import com.bibliotecaapi.demo.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libroDetalles) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroDetalles.getTitulo());
            libro.setIsbn(libroDetalles.getIsbn());
            libro.setAnioPublicacion(libroDetalles.getAnioPublicacion());
            libro.setAutor(libroDetalles.getAutor());
            return libroRepository.save(libro);
        }).orElse(null);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> buscarLibros(String titulo, Integer anio, String ordenarPor, String orden) {
        List<Libro> libros;

        if (titulo != null && anio != null) {
            libros = libroRepository.findByTituloContainingIgnoreCaseAndAnioPublicacion(titulo, anio);
        } else if (titulo != null) {
            libros = libroRepository.findByTituloContainingIgnoreCase(titulo);
        } else if (anio != null) {
            libros = libroRepository.findByAnioPublicacion(anio);
        } else {
            libros = libroRepository.findAll();
        }

        if (ordenarPor != null && orden != null) {
            libros.sort((l1, l2) -> {
                int comparacion = 0;
                if (ordenarPor.equals("titulo")) {
                    comparacion = l1.getTitulo().compareToIgnoreCase(l2.getTitulo());
                } else if (ordenarPor.equals("anio")) {
                    comparacion = Integer.compare(l1.getAnioPublicacion(), l2.getAnioPublicacion());
                }

                return orden.equals("desc") ? -comparacion : comparacion;
            });
        }

        return libros;
    }
}
