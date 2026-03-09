package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.Asiento;
import com.proyecto.cinegalaxy.services.AsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/asientos")
public class AsientoController {

    @Autowired
    private AsientoService asientoService;

    @GetMapping
    public List<Asiento> getAsientos() {
        return asientoService.getAsientos();
    }

    @GetMapping("/{id}")
    public Optional<Asiento> getAsientoById(@PathVariable Long id) {
        return asientoService.getAsientoById(id);
    }

    @PutMapping("/{id}")
    public Asiento updateAsiento(@PathVariable Long id, @RequestBody Asiento asiento) {
        return asientoService.updateAsiento(id, asiento);
    }

    @DeleteMapping("/{id}")
    public Asiento deleteAsiento(@PathVariable Long id) {
        return asientoService.deleteAsiento(id);
    }

    @GetMapping("/sala/{salaId}")
    public List<Asiento> getAsientosBySala(@PathVariable Long salaId) {
        return asientoService.getAsientosBySala(salaId);
    }

}
