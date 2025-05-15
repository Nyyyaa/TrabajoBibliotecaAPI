package com.bibliotecaapi.demo.controller;

import com.bibliotecaapi.demo.model.Autor;
import com.bibliotecaapi.demo.service.AutorService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Autor> obtenerAutorPorId(@PathVariable Long id) {
        return autorService.obtenerPorId(id);
    }

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.crearAutor(autor);
    }
}
