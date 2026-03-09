package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.Funcion;
import com.proyecto.cinegalaxy.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/funciones")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @GetMapping
    public List<Funcion> getFunciones() {
        return funcionService.getFunciones();
    }

    @GetMapping("/{id}")
    public Optional<Funcion> getFuncionById(@PathVariable Long id) {
        return funcionService.getFuncionById(id);
    }

    @PostMapping
    public Funcion createFuncion(@RequestBody Funcion funcion) {
        return funcionService.createFuncion(funcion);
    }

    @PutMapping("/{id}")
    public Funcion updateFuncion(@PathVariable Long id, @RequestBody Funcion funcion) {
        return funcionService.updateFuncion(id, funcion);
    }

    @DeleteMapping("/{id}")
    public Funcion deleteFuncion(@PathVariable Long id) {
        return funcionService.deleteFuncion(id);
    }

    // GET /api/funciones/pelicula/{peliculaId} → funciones activas de una película
    @GetMapping("/pelicula/{peliculaId}")
    public List<Funcion> getFuncionesByPelicula(@PathVariable Long peliculaId) {
        return funcionService.getFuncionesByPelicula(peliculaId);
    }

    // GET /api/funciones/pelicula/{peliculaId}/fecha/{fecha} → filtrar por fecha
    @GetMapping("/pelicula/{peliculaId}/fecha/{fecha}")
    public List<Funcion> getFuncionesByPeliculaAndFecha(
            @PathVariable Long peliculaId,
            @PathVariable LocalDate fecha) {
        return funcionService.getFuncionesByPeliculaAndFecha(peliculaId, fecha);
    }

    // GET /api/funciones/pelicula/{peliculaId}/sede/{sedeId}
    @GetMapping("/pelicula/{peliculaId}/sede/{sedeId}")
    public List<Funcion> getFuncionesByPeliculaAndSede(
            @PathVariable Long peliculaId,
            @PathVariable Long sedeId) {
        return funcionService.getFuncionesByPeliculaAndSede(peliculaId, sedeId);
    }

    // GET /api/funciones/pelicula/{peliculaId}/sede/{sedeId}/fecha/{fecha}
    @GetMapping("/pelicula/{peliculaId}/sede/{sedeId}/fecha/{fecha}")
    public List<Funcion> getFuncionesByPeliculaAndSedeAndFecha(
            @PathVariable Long peliculaId,
            @PathVariable Long sedeId,
            @PathVariable LocalDate fecha) {
        return funcionService.getFuncionesByPeliculaAndSedeAndFecha(peliculaId, sedeId, fecha);
    }

}
