package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.CategoriaProducto;
import com.proyecto.cinegalaxy.services.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categorias-producto")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @GetMapping
    public ResponseEntity<List<CategoriaProducto>> getAllCategorias() {
        return ResponseEntity.ok(categoriaProductoService.getCategoriasProducto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProducto> getCategoriaById(@PathVariable Long id) {
        return categoriaProductoService.getCagegoriaProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaProducto> createCategoria(@RequestBody CategoriaProducto categoriaProducto) {
        return ResponseEntity.ok(categoriaProductoService.createCategoriaProducto(categoriaProducto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProducto> updateCategoria(
            @PathVariable Long id,
            @RequestBody CategoriaProducto categoriaProducto) {
        return ResponseEntity.ok(categoriaProductoService.updateCategoriaProducto(id, categoriaProducto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaProducto> deleteCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaProductoService.deleteCategoriaProducto(id));
    }

}
