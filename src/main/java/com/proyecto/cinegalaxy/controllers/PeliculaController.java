package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.Pelicula;
import com.proyecto.cinegalaxy.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;


    @GetMapping
    public ResponseEntity<List<Pelicula>> getPeliculas() {
        return ResponseEntity.ok(peliculaService.getPeliculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable Long id) {
        return peliculaService.getPeliculaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.createPelicula(pelicula);
        return ResponseEntity.ok(nuevaPelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable Long id, @RequestBody Pelicula peliculaDetails) {
        Pelicula peliculaActualizada = peliculaService.updatePelicula(id, peliculaDetails);
        return ResponseEntity.ok(peliculaActualizada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Pelicula> deletePelicula(@PathVariable Long id) {
        Pelicula peliculaEliminada = peliculaService.deletePelicula(id);
        return ResponseEntity.ok(peliculaEliminada);
    }



}
