package com.proyecto.cinegalaxy.repositories;

import com.proyecto.cinegalaxy.models.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FuncionRepository extends JpaRepository<Funcion, Long> {

    List<Funcion> findByPelicula_PeliculaIdAndFecha(Long peliculaId, LocalDate fecha);

    List<Funcion> findByPelicula_PeliculaIdAndEstado(Long peliculaId, Integer estado);

    // Funciones de una película en una sede específica
    @Query("SELECT f FROM Funcion f WHERE f.pelicula.peliculaId = :peliculaId AND f.sala.sede.sedeId = :sedeId AND f.estado = 1")
    List<Funcion> findByPeliculaAndSede(@Param("peliculaId") Long peliculaId, @Param("sedeId") Long sedeId);

    // Funciones de una película en una sede y fecha específica
    @Query("SELECT f FROM Funcion f WHERE f.pelicula.peliculaId = :peliculaId AND f.sala.sede.sedeId = :sedeId AND f.fecha = :fecha AND f.estado = 1")
    List<Funcion> findByPeliculaAndSedeAndFecha(@Param("peliculaId") Long peliculaId, @Param("sedeId") Long sedeId, @Param("fecha") LocalDate fecha);
}
