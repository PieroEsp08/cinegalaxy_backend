package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Sala;

import java.util.List;
import java.util.Optional;

public interface SalaService {

    List<Sala> getSalas();

    Optional<Sala> getSalaById(Long id);

    Sala createSala(Sala sala);

    Sala updateSala(Long id, Sala sala);

    Sala deleteSala(Long id);

    List<Sala> getSalasBySede(Long sedeId);
}
