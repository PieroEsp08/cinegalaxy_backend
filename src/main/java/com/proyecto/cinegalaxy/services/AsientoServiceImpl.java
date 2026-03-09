package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Asiento;
import com.proyecto.cinegalaxy.repositories.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsientoServiceImpl implements AsientoService {

    @Autowired
    private AsientoRepository asientoRepository;

    @Override
    public List<Asiento> getAsientos() {
        return asientoRepository.findAll();
    }

    @Override
    public Optional<Asiento> getAsientoById(Long id) {
        return asientoRepository.findById(id);
    }

    @Override
    public Asiento updateAsiento(Long id, Asiento asiento) {
        return asientoRepository.findById(id).map(a -> {
            a.setFila(asiento.getFila());
            a.setNumero(asiento.getNumero());
            a.setTipo(asiento.getTipo());
            a.setEstado(asiento.getEstado());
            return asientoRepository.save(a);
        }).orElseThrow(() -> new RuntimeException("Asiento no encontrado con id: " + id));
    }

    @Override
    public Asiento deleteAsiento(Long id) {
        return asientoRepository.findById(id).map(asiento -> {
            asiento.setEstado(0); // Eliminación lógica
            return asientoRepository.save(asiento);
        }).orElseThrow(() -> new RuntimeException("Asiento no encontrado con id: " + id));
    }


    @Override
    public List<Asiento> getAsientosBySala(Long salaId) {
        return asientoRepository.findBySala_SalaId(salaId);
    }
}
