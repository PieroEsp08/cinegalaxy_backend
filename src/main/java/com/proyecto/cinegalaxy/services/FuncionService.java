package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Funcion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FuncionService {

    List<Funcion> getFunciones();

    Optional<Funcion> getFuncionById(Long id);

    Funcion createFuncion(Funcion funcion);

    Funcion updateFuncion(Long id, Funcion funcion);

    Funcion deleteFuncion(Long id);

    List<Funcion> getFuncionesByPelicula(Long peliculaId);

    List<Funcion> getFuncionesByPeliculaAndFecha(Long peliculaId, LocalDate fecha);

    List<Funcion> getFuncionesByPeliculaAndSede(Long peliculaId, Long sedeId);

    List<Funcion> getFuncionesByPeliculaAndSedeAndFecha(Long peliculaId, Long sedeId, LocalDate fecha);

}
