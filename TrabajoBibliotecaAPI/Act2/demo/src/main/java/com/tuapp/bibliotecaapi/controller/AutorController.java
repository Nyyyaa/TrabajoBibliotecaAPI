package com.tuapp.bibliotecaapi.controller;

import com.tuapp.bibliotecaapi.model.Autor;
import com.tuapp.bibliotecaapi.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Autor>> listarAutores() {
        List<Autor> autores = autorService.obtenerTodos();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorPorId(@PathVariable Long id) {
        Optional<Autor> autor = autorService.obtenerPorId(id);
        return autor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor) {
        try {
            Autor nuevoAutor = autorService.crearAutor(autor);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAutor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
