package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.TipoEntrada;
import com.proyecto.cinegalaxy.repositories.TipoEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEntradaImpl implements TipoEntradaService {

    @Autowired
    private TipoEntradaRepository tipoEntradaRepository;

    @Override
    public List<TipoEntrada> getTiposEntrada() {
        return tipoEntradaRepository.findAll();
    }

    @Override
    public Optional<TipoEntrada> getTipoEntradaById(Long id) {
        return tipoEntradaRepository.findById(id);
    }

    @Override
    public TipoEntrada createTipoEntrada(TipoEntrada tipoEntrada) {
        return tipoEntradaRepository.save(tipoEntrada);
    }

    @Override
    public TipoEntrada updateTipoEntrada(Long id, TipoEntrada tipoEntrada) {
        return tipoEntradaRepository.findById(id).map(t -> {
            t.setNombre(tipoEntrada.getNombre());
            t.setDescuentoPct(tipoEntrada.getDescuentoPct());
            t.setEstado(tipoEntrada.getEstado());
            return tipoEntradaRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("TipoEntrada no encontrado con id: " + id));
    }

    @Override
    public TipoEntrada deleteTipoEntrada(Long id) {
        return tipoEntradaRepository.findById(id).map(t -> {
            t.setEstado(0);
            return tipoEntradaRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("TipoEntrada no encontrado con id: " + id));
    }

}
