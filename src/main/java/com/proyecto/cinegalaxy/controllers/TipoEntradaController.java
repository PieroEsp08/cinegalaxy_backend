package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.TipoEntrada;
import com.proyecto.cinegalaxy.services.TipoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/tipos-entrada")
public class TipoEntradaController {

    @Autowired
    private TipoEntradaService tipoEntradaService;

    @GetMapping
    public List<TipoEntrada> getTiposEntrada() {
        return tipoEntradaService.getTiposEntrada();
    }

    @GetMapping("/{id}")
    public Optional<TipoEntrada> getTipoEntradaById(@PathVariable Long id) {
        return tipoEntradaService.getTipoEntradaById(id);
    }

    @PostMapping
    public TipoEntrada createTipoEntrada(@RequestBody TipoEntrada tipoEntrada) {
        return tipoEntradaService.createTipoEntrada(tipoEntrada);
    }

    @PutMapping("/{id}")
    public TipoEntrada updateTipoEntrada(@PathVariable Long id, @RequestBody TipoEntrada tipoEntrada) {
        return tipoEntradaService.updateTipoEntrada(id, tipoEntrada);
    }

    @DeleteMapping("/{id}")
    public TipoEntrada deleteTipoEntrada(@PathVariable Long id) {
        return tipoEntradaService.deleteTipoEntrada(id);
    }


}
