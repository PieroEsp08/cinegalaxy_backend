package com.proyecto.cinegalaxy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_entrada")
public class TipoEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoEntradaId;

    private String nombre;

    private Double descuentoPct;

    private Integer estado;

    public Long getTipoEntradaId() { return tipoEntradaId; }
    public void setTipoEntradaId(Long tipoEntradaId) { this.tipoEntradaId = tipoEntradaId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getDescuentoPct() { return descuentoPct; }
    public void setDescuentoPct(Double descuentoPct) { this.descuentoPct = descuentoPct; }

    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }


}
