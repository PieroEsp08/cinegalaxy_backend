package com.proyecto.cinegalaxy.repositories;

import com.proyecto.cinegalaxy.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findByEstado(Integer estado);

    List<Sala> findBySede_SedeId(Long sedeId);

    List<Sala> findBySede_SedeIdAndEstado(Long sedeId, Integer estado);
}
