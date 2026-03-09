package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Asiento;
import com.proyecto.cinegalaxy.models.Sala;
import com.proyecto.cinegalaxy.repositories.AsientoRepository;
import com.proyecto.cinegalaxy.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    @Override
    public List<Sala> getSalas() {
        return salaRepository.findAll();
    }

    @Override
    public Optional<Sala> getSalaById(Long id) {
        return salaRepository.findById(id);
    }

    @Override
    public Sala createSala(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public Sala updateSala(Long id, Sala sala) {
        return salaRepository.findById(id).map(s -> {
            s.setSede(sala.getSede());
            s.setNombre(sala.getNombre());
            s.setFormato(sala.getFormato());
            s.setFilas(sala.getFilas());
            s.setColumnas(sala.getColumnas());
            s.setEstado(sala.getEstado());
            return salaRepository.save(s);
        }).orElseThrow(() -> new RuntimeException("Sala no encontrada con id: " + id));
    }

    @Override
    public Sala deleteSala(Long id) {
        return salaRepository.findById(id).map(sala -> {
            sala.setEstado(0); // Eliminación lógica
            return salaRepository.save(sala);
        }).orElseThrow(() -> new RuntimeException("Sala no encontrada con id: " + id));
    }

    @Override
    public List<Sala> getSalasBySede(Long sedeId) {
        return salaRepository.findBySede_SedeId(sedeId);
    }

    // ── Genera asientos A1..An, B1..Bn, etc. según filas y columnas ──
    private void generarAsientos(Sala sala) {
        List<Asiento> asientos = new ArrayList<>();
        for (int f = 0; f < sala.getFilas(); f++) {
            String fila = String.valueOf((char) ('A' + f)); // A, B, C...
            for (int col = 1; col <= sala.getColumnas(); col++) {
                Asiento asiento = new Asiento(sala, fila, col, "ESTANDAR", 1);
                asientos.add(asiento);
            }
        }
        asientoRepository.saveAll(asientos);
    }
}
