package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Producto;
import com.proyecto.cinegalaxy.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        return productoRepository.findById(id).map(p -> {
            p.setNombre(producto.getNombre());
            p.setDescripcion(producto.getDescripcion());
            p.setPrecio(producto.getPrecio());
            p.setStock(producto.getStock());
            p.setImagen(producto.getImagen());
            p.setEstado(producto.getEstado());
            p.setCategoria(producto.getCategoria());
            return productoRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    @Override
    public Producto deleteProducto(Long id) {
        return productoRepository.findById(id).map(producto -> {
            producto.setEstado(0); // Eliminación lógica
            return productoRepository.save(producto);
        }).orElseThrow(() -> new RuntimeException("Pelicula no encontrada con id " + id));
    }

    @Override
    public List<Producto> getProductosByCategoria(Long categoriaId) {
        return productoRepository.findByCategoria_CategoriaId(categoriaId);
    }
}
