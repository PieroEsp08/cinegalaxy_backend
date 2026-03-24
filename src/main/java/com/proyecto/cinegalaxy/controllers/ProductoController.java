package com.proyecto.cinegalaxy.controllers;

import com.proyecto.cinegalaxy.models.Producto;
import com.proyecto.cinegalaxy.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.updateProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public Producto deleteProducto(@PathVariable Long id) {
        return productoService.deleteProducto(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> getProductosByCategoria(@PathVariable Long categoriaId) {
        return productoService.getProductosByCategoria(categoriaId);
    }

}