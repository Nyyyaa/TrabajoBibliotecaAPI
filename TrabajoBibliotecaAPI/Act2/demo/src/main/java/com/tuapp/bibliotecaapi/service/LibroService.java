package com.tuapp.bibliotecaapi.service;

import com.tuapp.bibliotecaapi.model.Autor;
import com.tuapp.bibliotecaapi.model.Libro;
import com.tuapp.bibliotecaapi.repository.LibroRepository;
import com.tuapp.bibliotecaapi.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro crearLibro(Libro libro) {
        Autor autor = autorRepository.findById(libro.getAutor().getId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        libro.setAutor(autor); 
        autor.agregarLibro(libro);

        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libroDetalles) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroDetalles.getTitulo());
            libro.setIsbn(libroDetalles.getIsbn());
            libro.setAnioPublicacion(libroDetalles.getAnioPublicacion());
            libro.setAutor(libroDetalles.getAutor());
            return libroRepository.save(libro);
        }).orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));
    }

    public void eliminarLibro(Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
        } else {
            throw new RuntimeException("El libro con ID " + id + " no existe.");
        }
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
                } else if (ordenarPor.equals("anioPublicacion")) {
                    comparacion = Integer.compare(l1.getAnioPublicacion(), l2.getAnioPublicacion());
                }

                return orden.equals("desc") ? -comparacion : comparacion;
            });
        }

        return libros;
    }
}
