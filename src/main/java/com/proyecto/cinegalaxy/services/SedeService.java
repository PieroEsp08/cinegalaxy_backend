package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Sede;

import java.util.List;
import java.util.Optional;

public interface SedeService {

    List<Sede> getSedes();

    Optional<Sede> getSedeById(Long id);

    Sede createSede(Sede sede);

    Sede updateSede(Long id, Sede sede);

    Sede deleteSede(Long id);
}
