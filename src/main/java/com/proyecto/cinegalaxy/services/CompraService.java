package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Compra;
import com.proyecto.cinegalaxy.request.CompraRequest;

import java.util.List;
import java.util.Optional;

public interface CompraService {

    List<Compra> getCompras();

    Optional<Compra> getCompraById(Long id);

    Compra crearCompra(CompraRequest request);
}
