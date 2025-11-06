package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {


    List<Producto> getProductos();

    Optional<Producto> getProductoById(Long id);

    Producto createProducto(Producto producto);

    Producto updateProducto(Long id, Producto producto);

    Producto deleteProducto(Long id);

    List<Producto> getProductosByCategoria(Long categoriaId);

}
