package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Asiento;

import java.util.List;
import java.util.Optional;

public interface AsientoService {

    List<Asiento> getAsientos();

    Optional<Asiento> getAsientoById(Long id);

    Asiento updateAsiento(Long id, Asiento asiento);

    Asiento deleteAsiento(Long id);

    List<Asiento> getAsientosBySala(Long salaId);
}
