package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.Compra;
import com.proyecto.cinegalaxy.request.CompraRequest;
import com.proyecto.cinegalaxy.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
@RestController
@RequestMapping("api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> getCompras() {
        return compraService.getCompras();
    }

    @GetMapping("/{id}")
    public Optional<Compra> getCompraById(@PathVariable Long id) {
        return compraService.getCompraById(id);
    }

    @PostMapping
    public ResponseEntity<?> crearCompra(@RequestBody CompraRequest request) {
        try {
            Compra compra = compraService.crearCompra(request);
            return ResponseEntity.ok(Map.of(
                    "compraId", compra.getCompraId(),
                    "codigoQr", compra.getCodigoQr(),
                    "estado", compra.getEstado()
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
