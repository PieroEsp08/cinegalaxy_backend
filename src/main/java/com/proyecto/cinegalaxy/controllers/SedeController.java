package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.Sede;
import com.proyecto.cinegalaxy.services.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/sedes")
public class SedeController {


    @Autowired
    private SedeService sedeService;

    @GetMapping
    public List<Sede> getSedes() {
        return sedeService.getSedes();
    }

    @GetMapping("/{id}")
    public Optional<Sede> getSedeById(@PathVariable Long id) {
        return sedeService.getSedeById(id);
    }

    @PostMapping
    public Sede createSede(@RequestBody Sede sede) {
        return sedeService.createSede(sede);
    }

    @PutMapping("/{id}")
    public Sede updateSede(@PathVariable Long id, @RequestBody Sede sede) {
        return sedeService.updateSede(id, sede);
    }

    @DeleteMapping("/{id}")
    public Sede deleteSede(@PathVariable Long id) {
        return sedeService.deleteSede(id);
    }
}
