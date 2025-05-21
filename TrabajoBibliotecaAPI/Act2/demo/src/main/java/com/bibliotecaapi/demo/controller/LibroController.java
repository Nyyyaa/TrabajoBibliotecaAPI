package com.bibliotecaapi.demo.controller;

import com.bibliotecaapi.demo.model.Libro;
import com.bibliotecaapi.demo.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.obtenerTodos();
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.crearLibro(libro);
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        return libroService.actualizarLibro(id, libroDetalles);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }

    @GetMapping("/buscar")
    public List<Libro> buscarLibros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false) String ordenarPor,
            @RequestParam(required = false) String orden) {
        return libroService.buscarLibros(titulo, anio, ordenarPor, orden);
    }

}
