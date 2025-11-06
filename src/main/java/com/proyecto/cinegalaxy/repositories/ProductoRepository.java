package com.proyecto.cinegalaxy.repositories;

import com.proyecto.cinegalaxy.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

    List<Producto> findByCategoria_CategoriaId(Long categoriaId);

}
