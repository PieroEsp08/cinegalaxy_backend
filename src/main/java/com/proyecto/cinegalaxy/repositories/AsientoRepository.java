package com.proyecto.cinegalaxy.repositories;

import com.proyecto.cinegalaxy.models.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsientoRepository extends JpaRepository<Asiento, Long> {

    List<Asiento> findBySala_SalaId(Long salaId);
}
