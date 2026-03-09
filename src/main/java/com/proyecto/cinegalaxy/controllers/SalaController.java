package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.Sala;
import com.proyecto.cinegalaxy.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public List<Sala> getSalas() {
        return salaService.getSalas();
    }

    @GetMapping("/{id}")
    public Optional<Sala> getSalaById(@PathVariable Long id) {
        return salaService.getSalaById(id);
    }

    @PostMapping
    public Sala createSala(@RequestBody Sala sala) {
        return salaService.createSala(sala);
    }

    @PutMapping("/{id}")
    public Sala updateSala(@PathVariable Long id, @RequestBody Sala sala) {
        return salaService.updateSala(id, sala);
    }

    @DeleteMapping("/{id}")
    public Sala deleteSala(@PathVariable Long id) {
        return salaService.deleteSala(id);
    }

    @GetMapping("/sede/{sedeId}")
    public List<Sala> getSalasBySede(@PathVariable Long sedeId) {
        return salaService.getSalasBySede(sedeId);
    }
}
