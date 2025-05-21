package com.bibliotecaapi.demo.service;

import com.bibliotecaapi.demo.model.Autor;
import com.bibliotecaapi.demo.model.Libro;
import com.bibliotecaapi.demo.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> obtenerPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor crearAutor(Autor autor) {
        if (autor.getLibros() != null) {
            for (Libro libro : autor.getLibros()) {
                libro.setAutor(autor);  
            }
        }
        return autorRepository.save(autor);
    }
}
