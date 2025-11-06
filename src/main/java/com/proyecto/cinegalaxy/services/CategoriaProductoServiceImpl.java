package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.CategoriaProducto;
import com.proyecto.cinegalaxy.repositories.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;


    @Override
    public List<CategoriaProducto> getCategoriasProducto() {
        return categoriaProductoRepository.findAll();
    }

    @Override
    public Optional<CategoriaProducto> getCagegoriaProductoById(Long id) {
        return categoriaProductoRepository.findById(id);
    }

    @Override
    public CategoriaProducto createCategoriaProducto(CategoriaProducto categoriaProducto) {
        return categoriaProductoRepository.save(categoriaProducto);
    }

    @Override
    public CategoriaProducto updateCategoriaProducto(Long id, CategoriaProducto categoriaProducto) {
        return categoriaProductoRepository.findById(id).map(p -> {
            p.setNombre(categoriaProducto.getNombre());
            p.setImagen(categoriaProducto.getImagen());
            p.setEstado(categoriaProducto.getEstado());

            return categoriaProductoRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Categoria Producto no encontrada con id: " + id));
    }

    @Override
    public CategoriaProducto deleteCategoriaProducto(Long id) {
        return categoriaProductoRepository.findById(id).map(categoriaProducto -> {
            categoriaProducto.setEstado(0); // Eliminación lógica
            return categoriaProductoRepository.save(categoriaProducto);
        }).orElseThrow(() -> new RuntimeException("Categoria Producto no encontrada con id " + id));
    }
}
