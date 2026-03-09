package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Sede;
import com.proyecto.cinegalaxy.repositories.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeServiceImpl implements SedeService {

    @Autowired
    private SedeRepository sedeRepository;


    @Override
    public List<Sede> getSedes() {
        return sedeRepository.findAll();
    }

    @Override
    public Optional<Sede> getSedeById(Long id) {
        return sedeRepository.findById(id);
    }

    @Override
    public Sede createSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public Sede updateSede(Long id, Sede sede) {
        return sedeRepository.findById(id).map(s -> {
            s.setNombre(sede.getNombre());
            s.setDireccion(sede.getDireccion());
            s.setDistrito(sede.getDistrito());
            s.setTelefono(sede.getTelefono());
            s.setImagen(sede.getImagen());
            s.setEstado(sede.getEstado());
            return sedeRepository.save(s);
        }).orElseThrow(() -> new RuntimeException("Sede no encontrada con id: " + id));
    }

    @Override
    public Sede deleteSede(Long id) {
        return sedeRepository.findById(id).map(sede -> {
            sede.setEstado(0); // Eliminación lógica
            return sedeRepository.save(sede);
        }).orElseThrow(() -> new RuntimeException("Sede no encontrada con id: " + id));
    }



}
