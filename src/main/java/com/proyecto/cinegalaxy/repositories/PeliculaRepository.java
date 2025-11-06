package com.proyecto.cinegalaxy.repositories;

import com.proyecto.cinegalaxy.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
}
