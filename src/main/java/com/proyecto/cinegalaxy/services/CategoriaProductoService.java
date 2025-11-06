package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.CategoriaProducto;

import java.util.List;
import java.util.Optional;

public interface CategoriaProductoService {

    List<CategoriaProducto> getCategoriasProducto();

    Optional<CategoriaProducto> getCagegoriaProductoById(Long id);

    CategoriaProducto createCategoriaProducto(CategoriaProducto categoriaProducto);

    CategoriaProducto updateCategoriaProducto(Long id, CategoriaProducto categoriaProducto);

    CategoriaProducto deleteCategoriaProducto(Long id);

}
