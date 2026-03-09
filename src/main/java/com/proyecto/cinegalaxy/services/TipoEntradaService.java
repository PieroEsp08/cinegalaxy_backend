package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.TipoEntrada;

import java.util.List;
import java.util.Optional;

public interface TipoEntradaService {

    List<TipoEntrada> getTiposEntrada();
    Optional<TipoEntrada> getTipoEntradaById(Long id);
    TipoEntrada createTipoEntrada(TipoEntrada tipoEntrada);
    TipoEntrada updateTipoEntrada(Long id, TipoEntrada tipoEntrada);
    TipoEntrada deleteTipoEntrada(Long id);
}
