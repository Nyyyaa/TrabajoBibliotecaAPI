package com.tuapp.bibliotecaapi.service;

import com.tuapp.bibliotecaapi.model.Autor;
import com.tuapp.bibliotecaapi.model.Libro;
import com.tuapp.bibliotecaapi.repository.AutorRepository;
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
