package com.bibliotecaapi.demo.service;

import com.bibliotecaapi.demo.model.Autor;
import com.bibliotecaapi.demo.model.Libro;
import com.bibliotecaapi.demo.repository.AutorRepository;
import com.bibliotecaapi.demo.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;

    public AutorService(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> obtenerPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor crearAutor(Autor autor) {
        Autor autorGuardado = autorRepository.save(autor);

        if (autor.getLibros() != null) {
            for (Libro libro : autor.getLibros()) {
                libro.setAutor(autorGuardado); 
                libroRepository.save(libro);   
            }
        }

        return autorGuardado;
    }
}

